package jp.co.keisuke.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.dao.AgeDao;
import jp.co.keisuke.web.entity.Age;
import jp.co.keisuke.web.util.DbUtil;

public class AgeService {

    public List<Age> findAll() {
        List<Age> list = new ArrayList<Age>();

        try (Connection conn = DbUtil.getConnection()) {
            AgeDao ageDao = new AgeDao(conn);
            list = ageDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
