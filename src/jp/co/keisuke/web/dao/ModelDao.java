package jp.co.keisuke.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.entity.Model;

public class ModelDao {

    private final String SELECT_ALL = "SELECT * FROM model ORDER BY model_id";

    private Connection connection;

    public ModelDao(Connection connection) {
        this.connection = connection;
    }

    public List<Model> findAll() {
        ArrayList<Model> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

            	Model model = new Model(rs.getInt("model_id"),rs.getString("model_str"));

                list.add(model);

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return list;
    }

}
