package jp.co.keisuke.web.service;

import java.sql.Connection;

import jp.co.keisuke.web.dao.UserInfoDao;
import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.util.DbUtil;

public class UserInfoService {

	public UserInfo findAll() {

        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            UserInfo user = userInfoDao.findAll();

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

	}

	public UserInfo findAllById(Integer id) {

        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            UserInfo user = userInfoDao.findAllById(id);

            return user;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

	}

    public UserInfo authentication(String loginId, String pass) {

        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);

            UserInfo user = userInfoDao.findByLoginIdAndPassword(loginId, pass);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public UserInfo findByPass(String pass) {

        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            return userInfoDao.findByPass(pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean existsUserByPass(String pass) {

        return findByPass(pass) != null;

    }

    public void insert(UserInfo userInfo) {

        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            userInfoDao.insert(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(UserInfo userUpdate, UserInfo loginUser) {

        try (Connection conn = DbUtil.getConnection()) {
        	UserInfoDao userInfoDao = new UserInfoDao(conn);

            userInfoDao.update(userUpdate, loginUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(UserInfo loginUser) {

        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            userInfoDao.deleteById(loginUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
