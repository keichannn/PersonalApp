package jp.co.keisuke.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.entity.Age;


public class AgeDao {

    private final String SELECT_ALL = "SELECT * FROM age ORDER BY age_id";

    private Connection connection;

    public AgeDao(Connection connection) {
        this.connection = connection;
    }

    //全件取得
    public List<Age> findAll() {
        ArrayList<Age> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

            	Age age = new Age(rs.getInt("age_id"),rs.getString("age_str"));

                list.add(age);

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return list;
    }
}
