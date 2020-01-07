package jp.co.keisuke.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.keisuke.web.entity.SoftInfo;
import jp.co.keisuke.web.service.SoftInfoService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/softSelect")
public class SoftSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        String softName = request.getParameter("softName");
        String sort = request.getParameter("sort");
        String from = request.getParameter("from");
        String keepingSoftName = request.getParameter("keepingSoftName");

        request.getSession().setAttribute("keepingSoftName", softName);

        if(!ParamUtil.isNullOrEmpty(keepingSoftName) && keepingSoftName.equals(softName)) {
        	request.getSession().setAttribute("keepingSoftName", keepingSoftName);
        }

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());

        List<SoftInfo> list = new ArrayList<>();
        SoftInfoService softInfoService = new SoftInfoService();

        if(!ParamUtil.isNullOrEmpty(sort) && !sort.equals("sort")) {

        	list = softInfoService.findSortedSoftInfo(sort,(String)request.getSession().getAttribute("keepingSoftName"));

        	request.setAttribute("softList", list);
            request.getRequestDispatcher("softSelectResult.jsp").forward(request, response);

        }

        SoftInfo cond = new SoftInfo(null, softName, null, null, null, null, null, null, null);

        list = softInfoService.find(cond, sessionInfo.getLoginUser());

        if (list.isEmpty() && from.equals("fromSoftSelect")) {

            request.setAttribute("errMsg", "※ 入力されたデータはありませんでした");
            request.getRequestDispatcher("softSelect.jsp").forward(request, response);
            return;

        } else if (list.isEmpty() && from.equals("fromSoftSelectResult")) {

            request.setAttribute("errMsg", "※ 入力されたデータはありませんでした");
            request.getRequestDispatcher("softSelectResult.jsp").forward(request, response);
            return;

        }

            request.setAttribute("softList", list);
            request.getRequestDispatcher("softSelectResult.jsp").forward(request, response);



	}
}
