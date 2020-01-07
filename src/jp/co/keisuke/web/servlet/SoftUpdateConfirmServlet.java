package jp.co.keisuke.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.keisuke.web.entity.SoftInfo;
import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.service.SoftInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/softUpdateConfirm")
public class SoftUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
        SoftInfo softUpdate = sessionInfo.getUpdateSoft();
        UserInfo loginUser = sessionInfo.getLoginUser();

        SoftInfoService softInfoService = new SoftInfoService();
        softInfoService.update(softUpdate, loginUser);

        sessionInfo.setPrevUpdateSoft(null);
        sessionInfo.setUpdateSoft(null);

        request.getRequestDispatcher("ResultToMypage.jsp").forward(request, response);

	}

}
