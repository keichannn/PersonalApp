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

@WebServlet("/softUpdateInput")
public class SoftUpdateInputServlet extends HttpServlet {
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

        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
        SoftInfo updateSoft = sessionInfo.getUpdateSoft();
        SoftInfoService softInfoService = new SoftInfoService();

        boolean hasError = false;

        if(ParamUtil.isNullOrEmpty(softName)) {
            request.setAttribute("nameErrMsg", "※ ソフト名は必須です");
            hasError = true;
        }

        if(ParamUtil.isNullOrEmpty(releaseDate)) {
            request.setAttribute("releaseErrMsg", "※ 発売日は必須です");
            hasError = true;

        } else if(!releaseDate.matches("^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]{1}|[12]{1}[0-9]{1}|3[01])$")) {

        	request.setAttribute("releaseErrMsg", "※ 発売日が正しくありません");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(price)) {
            request.setAttribute("priceErrMsg", "※ 価格は必須です");
            hasError = true;

        } else if(price.matches("￥[0-9]+,[0-9]{3}") || price.matches("￥[0-9]+")) {

            request.setAttribute("priceErrMsg", "※「￥」は付けないでください。");
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

        updateSoft.setSoftName(softName);
        updateSoft.setGenreStr(ParamUtil.getGenreNameByGenreId(genreId, sessionInfo.getGenreList()));
        updateSoft.setModelStr(ParamUtil.getModelNameByModelId(modelId, sessionInfo.getModelList()));
        updateSoft.setReleaseDate(releaseDate);
        updateSoft.setUrl(url);
        updateSoft.setPrice(price);

        if (hasError) {
            request.getRequestDispatcher("softUpdateInput.jsp").forward(request, response);
            return;
        }

        SoftInfo prevSoft = sessionInfo.getPrevUpdateSoft();

        if (softInfoService.existsSoftByPrevUpdateSoftNameAndUpdateSoftName(prevSoft.getSoftName(), softName)) {
            request.setAttribute("errMsg", "※ このソフト名はすでに登録されています");
            request.getRequestDispatcher("softUpdateInput.jsp").forward(request, response);
            return;
        }

        if(price.matches("[0-9]+")) {
        	updateSoft.setPrice("￥"+ParamUtil.getPrice(price));
        }

        if (prevSoft.equals(updateSoft)) {

            request.setAttribute("errMsg", "※ 1項目以上変更してください");
            request.getRequestDispatcher("softUpdateInput.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("softUpdateConfirm.jsp").forward(request, response);

    }

}
