package jp.co.keisuke.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.service.UserInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/userUpdateConfirm")
public class UserUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
        UserInfo userUpdate = sessionInfo.getUpdateUser();
        UserInfo loginUser = sessionInfo.getLoginUser();

        UserInfoService userInfoService = new UserInfoService();
        userInfoService.update(userUpdate, loginUser);

        sessionInfo.setPrevUpdateUser(null);
        sessionInfo.setUpdateUser(null);

        sessionInfo.setLoginUser(userUpdate);

        request.getRequestDispatcher("ResultToMypage.jsp").forward(request, response);

	}

}
