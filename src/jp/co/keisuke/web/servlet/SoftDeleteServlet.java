package jp.co.keisuke.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.keisuke.web.entity.SoftInfo;
import jp.co.keisuke.web.service.SoftInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/softDelete")
public class SoftDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String softName = request.getParameter("softName");

	        SoftInfoService softInfoService = new SoftInfoService();
	        SoftInfo softInfo = softInfoService.findBySoftName(softName);


	        if(softInfo != null) {

	        	SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
	        	sessionInfo.setSoftDelete(new SoftInfo());
	        	sessionInfo.getSoftDelete().setSoftName(softName);;

	        }

	        request.setAttribute("deleteSoft", softInfo);
	        request.getRequestDispatcher("softDeleteConfirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String softName = request.getParameter("softName");

	        boolean hasError = false;

	        if (ParamUtil.isNullOrEmpty(softName)) {

	            request.setAttribute("softNameErrMsg", "※ ソフト名は必須です");
	            hasError = true;

	        }

	        if (hasError) {

	            request.getRequestDispatcher("softDelete.jsp").forward(request, response);
	            return;

	        }

	        SoftInfoService softInfoService = new SoftInfoService();
	        SoftInfo softInfo = softInfoService.findBySoftName(softName);

	        if (softInfo == null) {

	            request.setAttribute("errMsg", "※ 入力されたデータは存在しません");
	            request.getRequestDispatcher("softDelete.jsp").forward(request, response);
	            return;

	        } else if(softInfo != null) {

	        	SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
	        	sessionInfo.setSoftDelete(new SoftInfo());
	        	sessionInfo.getSoftDelete().setSoftName(softName);;


	        }

	        request.setAttribute("deleteSoft", softInfo);
	        request.getRequestDispatcher("softDeleteConfirm.jsp").forward(request, response);
	}

}
