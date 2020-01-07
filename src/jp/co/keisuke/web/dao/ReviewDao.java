package jp.co.keisuke.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.entity.Review;
import jp.co.keisuke.web.entity.UserInfo;

public class ReviewDao {

	private static final String SELECT_ALL ="SELECT * FROM review";
	private static final String INSERT = "INSERT INTO review(id,user_name,soft_name,model_str,contents,dateTime) VALUES(?,?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM review WHERE id = ? AND contents = ?";

	private Connection conn;

	public ReviewDao(Connection conn ) {this.conn = conn;}

	public List<Review> findReviewData() {

		List<Review> list = new ArrayList<>();

    	try(PreparedStatement stmt = conn.prepareStatement(SELECT_ALL)){

    		ResultSet rs = stmt.executeQuery();

    		while(rs.next()) {

    			Review reviewInfo = new Review(rs.getInt("review_id"), rs.getInt("id"), rs.getString("user_name"), rs.getString("soft_name"), rs.getString("model_str"), rs.getString("contents"), rs.getString("dateTime"));
    			list.add(reviewInfo);

    		}

    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}

    	return list;

	}

	public void find(String deleteReview, UserInfo loginUser) {

    	try(PreparedStatement stmt = conn.prepareStatement(DELETE)){

    		stmt.setInt(1, loginUser.getId());
    		stmt.setString(2, deleteReview);

    		stmt.executeUpdate();

    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}

	}

	public void insert(Review reviewInfo) {

    	try(PreparedStatement stmt = conn.prepareStatement(INSERT)){

    		stmt.setInt(1, reviewInfo.getId());
    		stmt.setString(2, reviewInfo.getUserName());
    		stmt.setString(3, reviewInfo.getSoftStr());
    		stmt.setString(4, reviewInfo.getModelStr());
    		stmt.setString(5, reviewInfo.getContents());
    		stmt.setString(6, reviewInfo.getDateTime());

    		stmt.executeUpdate();

    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}

	}

	public void delete(String deleteReview , UserInfo loginUser) {

    	try(PreparedStatement stmt = conn.prepareStatement(DELETE)){

    		stmt.setInt(1, loginUser.getId());
    		stmt.setString(2, deleteReview);

    		stmt.executeUpdate();

    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}

	}

}
