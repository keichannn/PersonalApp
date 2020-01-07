package jp.co.keisuke.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.keisuke.web.entity.Age;
import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.service.UserInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/userInsert")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());

		if(sessionInfo.getAgeList()==null) {
	        request.setAttribute("ageErrMsg1", "※ エラーが発生しました");
	        request.setAttribute("ageErrMsg2","画面を更新してください。");
	        request.setAttribute("ageErrMsg3","それでも解消されなければ、");
	        request.setAttribute("ageErrMsg4","ログインしてログアウトしてください。");
	        request.getRequestDispatcher("topPage.jsp").forward(request, response);
		}

		request.getRequestDispatcher("userInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        String loginId = request.getParameter("loginId");
        String userName = request.getParameter("userName");
        String ageStr1 = request.getParameter("ageId");
        String pass = request.getParameter("pass");

        Integer ageId = ParamUtil.checkAndParseInt(ageStr1);

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());

        String ageStr2=null;

        for(Age age : sessionInfo.getAgeList()) {
        	if(age.getAgeId()==ageId) { ageStr2 = age.getAgeStr(); }
        }

        UserInfo userInfo = new UserInfo(null, loginId, userName, pass, ageId, ageStr2);

        sessionInfo.setRegisterUser(userInfo);

        boolean hasError = false;

        if (ParamUtil.isNullOrEmpty(loginId)) {
            request.setAttribute("idErrMsg", "※ IDは必須です。");
            hasError = true;

        } else if(!loginId.matches("[A-Za-z\\d]{4,}")) {
        	request.setAttribute("idErrMsg", "※ IDが正しくありません");
        	hasError = true;
        }


        if (ParamUtil.isNullOrEmpty(userName)) {
            request.setAttribute("nameErrMsg", "※ 名前は必須です。");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(pass)) {
            request.setAttribute("passErrMsg", "※ PASSは必須です。");
            hasError = true;

        } else if(!pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,16}")) {
            request.setAttribute("passErrMsg", "※ PASSが正しくありません");
            hasError = true;
        }

        if (hasError) {
            request.getRequestDispatcher("userInsert.jsp").forward(request, response);
        }

        // PASS重複チェック
        UserInfoService userInfoService = new UserInfoService();

        if (userInfoService.existsUserByPass(pass)) {
            request.setAttribute("errMsg", "※ PASSが重複しています");
            request.getRequestDispatcher("userInsert.jsp").forward(request, response);
        }

        request.getRequestDispatcher("userInsertConfirm.jsp").forward(request, response);

	}

}
