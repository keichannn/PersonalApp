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

@WebServlet("/softInsert")
public class SoftInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        String softName = request.getParameter("softName");
        String genreStr = request.getParameter("genreId");
        String modelStr = request.getParameter("modelId");
        String releaseDate = request.getParameter("releaseDate");
        String price = request.getParameter("price");
        String url = request.getParameter("url");

        Integer genreId = ParamUtil.checkAndParseInt(genreStr);
        Integer modelId = ParamUtil.checkAndParseInt(modelStr);

        SoftInfo softInfo = new SoftInfo();

        boolean hasError = false;

        if (ParamUtil.isNullOrEmpty(softName)) {
            request.setAttribute("nameErrMsg", "※ ソフト名は必須です");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(releaseDate)) {
            request.setAttribute("releaseErrMsg", "※ 発売日は必須です");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(price)) {
            request.setAttribute("priceErrMsg", "※ 価格は必須です");
            hasError = true;

        } else if(!ParamUtil.confirmPriceWhetherTrue(price)) {
            request.setAttribute("priceErrMsg", "※ 価格が正しくありません");
            hasError = true;

        }

        if (ParamUtil.isNullOrEmpty(url)) {
            request.setAttribute("urlErrMsg1", "※ URLは必須です");
            hasError = true;

        } else if (!url.matches("https?://[\\w/:%#\\$&\\?\\(\\)~\\.=\\+\\-]+")) {
            request.setAttribute("urlErrMsg2", "※ URLが正しくありません");
            hasError = true;
        }

        if (hasError) {
            request.getRequestDispatcher("softInsert.jsp").forward(request, response);
            return;
        }

        SoftInfoService softInfoService = new SoftInfoService();

        if (softInfoService.existsSoftBySoftName(softName)) {
            request.setAttribute("errMsg", "※ このソフト名はすでに登録されています");
            request.getRequestDispatcher("softInsert.jsp").forward(request, response);
            return;
        }

        softInfo.setSoftName(softName);
        softInfo.setGenreId(genreId);
        softInfo.setModelId(modelId);
        softInfo.setReleaseDate(releaseDate);
        softInfo.setUrl(url);

        if(price.matches("[0-9]+")) {
        	softInfo.setPrice("￥"+ParamUtil.getPrice(price));
        } else softInfo.setPrice(price);

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
        softInfo.setGenreStr(ParamUtil.getGenreNameByGenreId(genreId, sessionInfo.getGenreList()));
        softInfo.setModelStr(ParamUtil.getModelNameByModelId(modelId, sessionInfo.getModelList()));
        sessionInfo.setRegisterSoft(softInfo);

        request.getRequestDispatcher("softInsertConfirm.jsp").forward(request, response);

	}

}
