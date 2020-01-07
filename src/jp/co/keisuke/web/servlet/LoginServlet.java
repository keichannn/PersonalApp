package jp.co.keisuke.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.service.UserInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String loginId = request.getParameter("loginId");
        String pass = request.getParameter("pass");

        boolean hasError = false;

        if (ParamUtil.isNullOrEmpty(loginId)) {

            request.setAttribute("idErrMsg", "※ IDは必須です");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(pass)) {

            request.setAttribute("passErrMsg", "※ PASSは必須です");
            hasError = true;
        }

        if (hasError) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // 認証処理
        UserInfoService userInfoService = new UserInfoService();
        UserInfo user = userInfoService.authentication(loginId, pass);

        if (user != null) {

            HttpSession session = request.getSession();
            SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
            sessionInfo.setLoginUser(user);
            session.setAttribute("sessionInfo", sessionInfo);

            request.getRequestDispatcher("mypage.jsp").forward(request, response);

        } else {

            request.setAttribute("errMsg", "※ IDまたはPASSが間違っています");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
	}

}
