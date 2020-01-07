package jp.co.keisuke.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.keisuke.web.entity.Review;
import jp.co.keisuke.web.entity.SoftInfo;
import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.service.ReviewService;
import jp.co.keisuke.web.service.SoftInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/reviewDelete")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String deleteReview = request.getParameter("deleteReview");

		ReviewService reviewService = new ReviewService();
		SoftInfoService softInfoService = new SoftInfoService();

		SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());

		//プルダウンメニューで表示するための処理
        UserInfo userInfo = sessionInfo.getLoginUser();
        List<SoftInfo> softList = softInfoService.findAll(userInfo);
        //

		reviewService.delete(deleteReview, sessionInfo.getLoginUser());

		List<Review> list = reviewService.findReviewData();

		request.setAttribute("softList", softList);
		request.setAttribute("reviewList", list);
		request.getRequestDispatcher("review.jsp").forward(request, response);

	}

}
