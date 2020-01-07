package jp.co.keisuke.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.dao.GenreDao;
import jp.co.keisuke.web.entity.Genre;
import jp.co.keisuke.web.util.DbUtil;

public class GenreService {

    public List<Genre> findAll() {
        List<Genre> list = new ArrayList<Genre>();

        try (Connection conn = DbUtil.getConnection()) {
        	GenreDao genreDao = new GenreDao(conn);
            list = genreDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
