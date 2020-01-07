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

@WebServlet("/softUpdate")
public class SoftUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        	request.getRequestDispatcher("softUpdate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        String softName = request.getParameter("softName");

        if (ParamUtil.isNullOrEmpty(softName)) {
            request.setAttribute("softNameErrMsg", "※ ソフト名は必須です");
            request.getRequestDispatcher("softUpdate.jsp").forward(request, response);
            return;
        }

        SoftInfoService softInfoService = new SoftInfoService();
        SoftInfo softInfo = softInfoService.findBySoftName(softName);

        if (softInfo == null) {

            request.setAttribute("errMsg", "※ 入力されたデータは存在しません");
            request.getRequestDispatcher("softUpdate.jsp").forward(request, response);
            return;

        }

        SoftInfo updateSoft = new SoftInfo();
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());

        updateSoft.setSoftName(softInfo.getSoftName());
        updateSoft.setGenreId(softInfo.getGenreId());;


        try {

            updateSoft.setGenreStr(ParamUtil.getGenreNameByGenreId(softInfo.getGenreId(), sessionInfo.getGenreList()));
            updateSoft.setModelId(softInfo.getModelId());
            updateSoft.setModelStr(ParamUtil.getModelNameByModelId(softInfo.getModelId(), sessionInfo.getModelList()));

        } catch(Exception e) {

        request.setAttribute("errMsg1", "※ 情報を取得できませんでした。");
        request.setAttribute("errMsg2","一度TOPへ戻り、画面を更新するか、");
        request.setAttribute("errMsg3","ログアウトしてください。");
        request.getRequestDispatcher("softUpdate.jsp").forward(request, response);

    }

        updateSoft.setReleaseDate(softInfo.getReleaseDate());
        updateSoft.setPrice(softInfo.getPrice());
        updateSoft.setUrl(softInfo.getUrl());

        sessionInfo.setPrevUpdateSoft(softInfo);
        sessionInfo.setUpdateSoft(updateSoft);

        request.getRequestDispatcher("softUpdateInput.jsp").forward(request, response);

	}
}
