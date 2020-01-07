package jp.co.keisuke.web.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.keisuke.web.entity.Age;
import jp.co.keisuke.web.entity.Review;
import jp.co.keisuke.web.entity.SoftInfo;
import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.service.AgeService;
import jp.co.keisuke.web.service.ReviewService;
import jp.co.keisuke.web.service.SoftInfoService;
import jp.co.keisuke.web.service.UserInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AgeService ageService = new AgeService();
		UserInfoService userInfoService = new UserInfoService();
		SoftInfoService softInfoService = new SoftInfoService();
		ReviewService reviewService = new ReviewService();

		List<Review> list = reviewService.findReviewData();

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());

        UserInfo userInfo = sessionInfo.getLoginUser();
        List<SoftInfo> softList = softInfoService.findAll(userInfo);

        List<Age> ageList = ageService.findAll();

        for(Age age : ageList) {
        	if(age.getAgeId()==userInfoService.findAll().getAgeId()) {
        		request.getSession().setAttribute("ageStrForReview", age.getAgeStr());
        	}
        }

		if(sessionInfo.getModelList()==null) {

	        request.setAttribute("ageErrMsg1", "※ エラーが発生しました。");
	        request.setAttribute("ageErrMsg2","ログアウトしてログインしてください。");
    		request.getRequestDispatcher("mypage.jsp").forward(request, response);

		}

		request.setAttribute("reviewList", list);
		request.setAttribute("softList", softList);
		request.getRequestDispatcher("review.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String softName = request.getParameter("softName");
		String modelStr = request.getParameter("modelId");
		String contents = request.getParameter("contents");

		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("y/MM/dd/ HH:mm:ss");

		//ParamUtilから取得
		Integer modelId = ParamUtil.checkAndParseInt(modelStr);
		SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
		String modelName = ParamUtil.getModelNameByModelId(modelId, sessionInfo.getModelList());
		//

		//newで取得
		Review reviewInfo = new Review(null,sessionInfo.getLoginUser().getId(), sessionInfo.getLoginUser().
				                         getUserName(), softName, modelName, contents,fmt.format(nowDateTime));
		ReviewService reviewService = new ReviewService();
		//

		boolean hasErr = false;

        if (ParamUtil.isNullOrEmpty(softName)) {
            request.setAttribute("nameErrMsg", "※ ソフト名は必須です");
            hasErr = true;
        }

        if (ParamUtil.isNullOrEmpty(contents)) {
            request.setAttribute("contentsErrMsg", "※ コメントは必須です");
            hasErr = true;
        }

        if(hasErr) {

    		request.getRequestDispatcher("review.jsp").forward(request, response);
        	return;

        }

		reviewService.insert(reviewInfo);

		List<Review> list = reviewService.findReviewData();

		request.getSession().setAttribute("dateTime", fmt.format(nowDateTime));
		request.setAttribute("reviewList", list);
		request.getRequestDispatcher("review.jsp").forward(request, response);

	}

}
