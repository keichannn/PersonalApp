package jp.co.keisuke.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.dao.ModelDao;
import jp.co.keisuke.web.entity.Model;
import jp.co.keisuke.web.util.DbUtil;

public class ModelService {

    public List<Model> findAll() {
        List<Model> list = new ArrayList<Model>();

        try (Connection conn = DbUtil.getConnection()) {
        	ModelDao modelDao = new ModelDao(conn);
            list = modelDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
