package jp.co.keisuke.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.dao.SoftInfoDao;
import jp.co.keisuke.web.entity.SoftInfo;
import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.util.DbUtil;

public class SoftInfoService {

    public List<SoftInfo> find(SoftInfo cond, UserInfo loginUser) {

        List<SoftInfo> list = new ArrayList<SoftInfo>();

        try (Connection conn = DbUtil.getConnection()) {
            SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            list = softInfoDao.find(cond, loginUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SoftInfo findById(UserInfo loginUser) {

        try (Connection conn = DbUtil.getConnection()) {
            SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            return softInfoDao.findById(loginUser);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<SoftInfo> findAll(UserInfo loginUser) {

        try (Connection conn = DbUtil.getConnection()) {
            SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            return softInfoDao.findAll(loginUser);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<SoftInfo> findAllByPartialMatch(UserInfo loginUser) {

        try (Connection conn = DbUtil.getConnection()) {
            SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            return softInfoDao.findAllByPartialMatch(loginUser);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public SoftInfo findBySoftName(String softName) {

        try (Connection conn = DbUtil.getConnection()) {
            SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            return softInfoDao.findBySoftName(softName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<SoftInfo> findAllSoftInfo() {

        try (Connection conn = DbUtil.getConnection()) {
            SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            return softInfoDao.findAllSoftInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<SoftInfo> findSortedSoftInfo(String sort, String softName) {

        List<SoftInfo> list = new ArrayList<SoftInfo>();

        try (Connection conn = DbUtil.getConnection()) {
            SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            list = softInfoDao.findSortedSoftInfo(sort,softName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public boolean existSoftById(UserInfo loginUser) {

    	return findById(loginUser) != null;
    }

    public boolean existsSoftBySoftName(String softName) {

        return findBySoftName(softName) != null;

    }

    public boolean existsSoftByPrevUpdateSoftNameAndUpdateSoftName(String prevUpdateSoftName, String updateSoftName) {

    	boolean whetherExist=false;

    	List<SoftInfo> softInfo = findAllSoftInfo();

    	for(SoftInfo soft : softInfo) {
    		if(soft.getSoftName().equals(prevUpdateSoftName)) {
    			soft.setSoftName("");
    		}
    	}

    	for(SoftInfo soft : softInfo) {
    		if(soft.getSoftName().equals(updateSoftName)) {
    			whetherExist = true;
    		}
    	}

        return whetherExist;

    }



    public void insert(SoftInfo resisterSoftInfo, UserInfo loginUserInfo) {

    	try(Connection conn = DbUtil.getConnection()){
    		SoftInfoDao softInfoDao = new SoftInfoDao(conn);
    		softInfoDao.insert(resisterSoftInfo, loginUserInfo);

    	} catch(Exception e) {
    		e.printStackTrace();
    	}

    }

    public void update(SoftInfo softUpdate, UserInfo loginUser) {

        try (Connection conn = DbUtil.getConnection()) {
        	SoftInfoDao softInfoDao = new SoftInfoDao(conn);

            softInfoDao.update(softUpdate, loginUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(UserInfo loginUser) {

        try (Connection conn = DbUtil.getConnection()) {

        	SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            softInfoDao.deleteById(loginUser);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteByIdAndSoftName(UserInfo loginUser, SoftInfo deleteSoft) {

        try (Connection conn = DbUtil.getConnection()) {

        	SoftInfoDao softInfoDao = new SoftInfoDao(conn);
            softInfoDao.deleteByIdAndSoftName(loginUser, deleteSoft);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
