package jp.co.keisuke.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.service.SoftInfoService;
import jp.co.keisuke.web.service.UserInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/userDelete")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String selectPage = request.getParameter("selectPage");

		if(selectPage.equals("yes")) {

			SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
			UserInfo loginUser = sessionInfo.getLoginUser();

			UserInfoService userInfoService = new UserInfoService();
			SoftInfoService softInfoService = new SoftInfoService();
			userInfoService.deleteById(loginUser);

			if(softInfoService.existSoftById(loginUser)) {
				softInfoService.deleteById(loginUser);
			}

			sessionInfo.setLoginUser(null);

			request.getRequestDispatcher("userDeleteResult.jsp").forward(request, response);

			return;

		}

		request.getRequestDispatcher("userDelete.jsp").forward(request, response);

	}
}
