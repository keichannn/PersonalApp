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

@WebServlet("/userInsertConfirm")
public class UserInsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

        String rePass = request.getParameter("rePass");
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
        UserInfo userInfo = sessionInfo.getRegisterUser();

        if (!userInfo.getPass().equals(rePass)) {

            request.setAttribute("errMsg", "※ 前画面で入力したパスワードと一致しません");
            request.getRequestDispatcher("userInsertConfirm.jsp").forward(request, response);
            return;

        }

        UserInfoService userInfoService = new UserInfoService();
        userInfoService.insert(userInfo);

        // 登録用データをセッションから破棄
        sessionInfo.setRegisterUser(null);

        request.getRequestDispatcher("ResultToToppage.jsp").forward(request, response);

	}
}
