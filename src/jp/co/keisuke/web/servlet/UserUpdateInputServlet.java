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

@WebServlet("/userUpdateInput")
public class UserUpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserInfo updateUser = new UserInfo();
        UserInfoService userInfoService = new UserInfoService();

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());

        UserInfo userInfo = userInfoService.findAllById(sessionInfo.getLoginUser().getId());

        updateUser.setId(sessionInfo.getLoginUser().getId());
        updateUser.setLoginId(userInfo.getLoginId());
        updateUser.setUserName(userInfo.getUserName());
        updateUser.setAgeId(userInfo.getAgeId());
        updateUser.setPass(userInfo.getPass());

        sessionInfo.setPrevUpdateUser(userInfo);
        sessionInfo.setUpdateUser(updateUser);

        request.getRequestDispatcher("userUpdateInput.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

        String loginId = request.getParameter("loginId");
        String userName = request.getParameter("userName");
        String ageStr = request.getParameter("age");
        String pass = request.getParameter("pass");

        Integer ageId = ParamUtil.checkAndParseInt(ageStr);

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
        UserInfo updateUser = sessionInfo.getUpdateUser();
        UserInfoService userInfoService = new UserInfoService();

        boolean hasError = false;

        if (ParamUtil.isNullOrEmpty(loginId)) {
            request.setAttribute("loginIdErrMsg", "※ ログインIDは必須です");
            hasError = true;

        } else if(!loginId.matches("[A-Za-z\\d]{4,}")) {
        	request.setAttribute("loginIdErrMsg", "※ IDが正しくありません");
        	hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(userName)) {
            request.setAttribute("userNameErrMsg", "※ ユーザ名は必須です");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(pass)) {
            request.setAttribute("passErrMsg", "※ PASSは必須です");
            hasError = true;

        } else if(!pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,16}")) {

            request.setAttribute("passErrMsg", "※ PASSは正しくありません");
            hasError = true;

		}

        updateUser.setLoginId(loginId);;
        updateUser.setUserName(userName);
        updateUser.setAgeId(ageId);
        updateUser.setPass(pass);

        for(Age age : sessionInfo.getAgeList()) {
        	if(age.getAgeId() == ageId) {
        		updateUser.setAgeStr(age.getAgeStr());
        	}
        }

        if (hasError) {
            request.getRequestDispatcher("userUpdateInput.jsp").forward(request, response);
            return;
        }

        UserInfo prevUser = sessionInfo.getPrevUpdateUser();

        if (userInfoService.existsUserByPass(pass)) {

            request.setAttribute("passErrMsg", "※ PASSが重複しています");
            request.getRequestDispatcher("userUpdateInput.jsp").forward(request, response);
            return;

        }

        if (prevUser.equals(updateUser)) {

            request.setAttribute("errMsg", "※ 1項目以上変更してください");
            request.getRequestDispatcher("userUpdateInput.jsp").forward(request, response);
            return;

        }

        request.getRequestDispatcher("userUpdateConfirm.jsp").forward(request, response);

	}

}
