package jp.co.keisuke.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.entity.Genre;

public class GenreDao {

    private final String SELECT_ALL = "SELECT * FROM genre ORDER BY genre_id";

    private Connection connection;

    public GenreDao(Connection connection) {
        this.connection = connection;
    }

    public List<Genre> findAll() {
        ArrayList<Genre> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

            	Genre genre = new Genre(rs.getInt("genre_id"),rs.getString("genre_str"));

                list.add(genre);

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return list;
    }

}
