package jp.co.keisuke.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.dao.ReviewDao;
import jp.co.keisuke.web.entity.Review;
import jp.co.keisuke.web.entity.UserInfo;
import jp.co.keisuke.web.util.DbUtil;

public class ReviewService {

	public ReviewService(){}

	public List<Review> findReviewData(){

        List<Review> list = new ArrayList<Review>();

        try (Connection conn = DbUtil.getConnection()) {

        	ReviewDao reviewDao = new ReviewDao(conn);
            list = reviewDao.findReviewData();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

	}

	public void insert(Review reviewInfo) {

        try (Connection conn = DbUtil.getConnection()) {

        	ReviewDao reviewDao = new ReviewDao(conn);
            reviewDao.insert(reviewInfo);

        } catch (Exception e) {

            e.printStackTrace();

        }

	}

	public void delete(String deleteReview, UserInfo loginUser) {

        try (Connection conn = DbUtil.getConnection()) {

        	ReviewDao reviewDao = new ReviewDao(conn);
            reviewDao.delete(deleteReview, loginUser);

        } catch (Exception e) {

            e.printStackTrace();

        }

	}

}
