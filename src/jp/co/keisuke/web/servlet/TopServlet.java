package jp.co.keisuke.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.keisuke.web.entity.Age;
import jp.co.keisuke.web.entity.Genre;
import jp.co.keisuke.web.entity.Model;
import jp.co.keisuke.web.service.AgeService;
import jp.co.keisuke.web.service.GenreService;
import jp.co.keisuke.web.service.ModelService;
import jp.co.keisuke.web.util.ParamUtil;

@WebServlet("/top")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AgeService ageService = new AgeService();
        GenreService genreService = new GenreService();
        ModelService modelService = new ModelService();

        List<Age> ageList = ageService.findAll();
        List<Genre> genreList = genreService.findAll();
        List<Model> modelList = modelService.findAll();


        HttpSession session = request.getSession();
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
        sessionInfo.setAgeList(ageList);
        sessionInfo.setGenreList(genreList);
        sessionInfo.setModelList(modelList);

        session.setAttribute("sessionInfo", sessionInfo);

		request.getRequestDispatcher("topPage.jsp").forward(request, response);

	}
}
