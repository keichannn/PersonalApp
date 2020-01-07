package jp.co.keisuke.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.keisuke.web.entity.SoftInfo;
import jp.co.keisuke.web.entity.UserInfo;

public class SoftInfoDao {

	private static final String SELECT_ALL_SOFT = "SELECT id, soft_name, s.genre_id, genre_str, s.model_id, model_str, release_date, price, url FROM soft_information s JOIN genre g ON s.genre_id = g.genre_id JOIN model m ON s.model_id = m.model_id";
    private static final String SELECT = "SELECT soft_id, id, soft_name, genre_str, model_str, release_date, price, url FROM soft_information s JOIN genre g ON s.genre_id = g.genre_id JOIN model m ON s.model_id = m.model_id WHERE ";
    private static final String SELECT_BY_ID = "SELECT id FROM soft_information WHERE id = ?";
    private static final String SELECT_BY_SOFT_NAME = "SELECT soft_name, s.genre_id, genre_str, s.model_id, model_str, release_date, price, url FROM soft_information s JOIN genre g ON s.genre_id = g.genre_id JOIN model m ON s.model_id = m.model_id WHERE soft_name = ?";
    private static final String SELECT_ALL_LIKE_SOFT_NAME = "SELECT soft_name, s.genre_id, genre_str, s.model_id, model_str, release_date, price, url FROM soft_information s JOIN genre g ON s.genre_id = g.genre_id JOIN model m ON s.model_id = m.model_id WHERE soft_name LIKE '%?%' AND id = ?";
    private static final String SELECT_ALL = "SELECT soft_id, id, soft_name, s.genre_id, genre_str, s.model_id, model_str, release_date, price, url FROM soft_information s JOIN genre g ON s.genre_id = g.genre_id JOIN model m ON s.model_id = m.model_id WHERE id = ? ORDER BY soft_id";
	private static final String SELECT_SORTED_SOFT = "SELECT soft_id, soft_name, genre_str, model_str, release_date, price, url FROM soft_information s JOIN genre g ON s.genre_id = g.genre_id JOIN model m ON s.model_id = m.model_id WHERE soft_name LIKE ? || '%' ORDER BY ";
    private static final String ORDER_BY = " ORDER BY id";
    private static final String INSERT = "INSERT INTO soft_information(id,soft_name,genre_id,model_id,release_date,price,url) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE soft_information SET soft_name = ? ,genre_id = ?, model_id = ?, release_date = ?, price = ? , url = ? WHERE soft_name = ? AND id = ?";
    private static final String DELETE_BY_SOFT_NAME_AND_ID = "delete from soft_information where soft_name = ? AND id = ?";
    private static final String DELETE_BY_ID = "delete from soft_information where id = ?";

    private Connection connection;

    public SoftInfoDao(Connection connection) {
        this.connection = connection;
    }

    public List<SoftInfo> findAllSoftInfo() {

        ArrayList<SoftInfo> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_SOFT)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                SoftInfo u = new SoftInfo(rs.getInt("id"), rs.getString("soft_name"), null,
                		                   rs.getString("genre_str"), null, rs.getString("model_str"),
                		                   rs.getString("release_date"), rs.getString("price"), rs.getString("url"));
                list.add(u);
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return list;

    }

    public List<SoftInfo> findSortedSoftInfo(String sort, String softName) {

    	String str = null;

    	if(sort.equals("softName_asc")) {

     		str = SELECT_SORTED_SOFT + "soft_name ASC";

     	} else if(sort.equals("softName_desc")) {

     		str = SELECT_SORTED_SOFT + "soft_name DESC";

     	} else if(sort.equals("releaseDate_asc")) {

    		str = SELECT_SORTED_SOFT + "release_date ASC";

    	} else if(sort.equals("releaseDate_desc")) {

    		str = SELECT_SORTED_SOFT + "release_date DESC";

    	} else if(sort.equals("price_asc")) {

    		str = SELECT_SORTED_SOFT + "price ASC";

    	} else if(sort.equals("price_desc")) {

    		str = SELECT_SORTED_SOFT + "price DESC";

    	}

        ArrayList<SoftInfo> list = new ArrayList<>();

        SoftInfo s = null;

        try (PreparedStatement stmt = connection.prepareStatement(str)) {

        	stmt.setString(1, softName);

            ResultSet rs = stmt.executeQuery();

        	if(sort.equals("price_asc") || sort.equals("price_desc")) {

	            while (rs.next()) {

	            	if(!rs.getString("price").equals("未定")&&!rs.getString("price").equals("URL参照")) {

	            		s = new SoftInfo(rs.getInt("soft_id"), null, rs.getString("soft_name"), null,
	 		                   rs.getString("genre_str"), null, rs.getString("model_str"),
	 		                   rs.getString("release_date"), rs.getString("price"), rs.getString("url"));

	                    list.add(s);

	            	}

	            }

        	}

        	while (rs.next()) {

        		s = new SoftInfo(rs.getInt("soft_id"), null, rs.getString("soft_name"), null,
		                   rs.getString("genre_str"), null, rs.getString("model_str"),
		                   rs.getString("release_date"), rs.getString("price"), rs.getString("url"));

                list.add(s);

            }


        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return list;

    }

    public List<SoftInfo> findAll(UserInfo loginUser) {

        ArrayList<SoftInfo> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL)) {

        	stmt.setInt(1, loginUser.getId());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                SoftInfo u = new SoftInfo(rs.getInt("soft_id"), rs.getInt("id"), rs.getString("soft_name"), null,
                		                   rs.getString("genre_str"), null, rs.getString("model_str"),
                		                   rs.getString("release_date"), rs.getString("price"), rs.getString("url"));
                list.add(u);
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return list;
    }

    public List<SoftInfo> findAllByPartialMatch(UserInfo loginUser) {

        ArrayList<SoftInfo> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_LIKE_SOFT_NAME)) {

        	stmt.setString(1, loginUser.getUserName());
        	stmt.setInt(2, loginUser.getId());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                SoftInfo u = new SoftInfo(rs.getInt("soft_id"), rs.getInt("id"), rs.getString("soft_name"), null,
                		                   rs.getString("genre_str"), null, rs.getString("model_str"),
                		                   rs.getString("release_date"), rs.getString("price"), rs.getString("url"));
                list.add(u);
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return list;
    }

    public List<SoftInfo> find(SoftInfo softInfo, UserInfo loginUser) {

        ArrayList<String> whereCond = new ArrayList<>();
        ArrayList<Object> param = new ArrayList<>();

        if (softInfo.softNameisEmptyCondition()) {

            return findAll(loginUser);

        } else if (!softInfo.softNameisEmptyCondition()) {

            whereCond.add("soft_name LIKE ? || '%'");
            param.add(softInfo.getSoftName());

        }

        whereCond.add("s.id = ?");
        param.add(loginUser.getId());

        String whereString = String.join(" AND ", whereCond.toArray(new String[] {}));

        ArrayList<SoftInfo> list = new ArrayList<>();

        String sql = SELECT + whereString + ORDER_BY;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            for (int i = 0; i < param.size(); i++) {

            	if(i == 0) {

            		stmt.setObject(i + 1, param.get(i));

            	}

                stmt.setObject(i + 1, param.get(i));
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                SoftInfo u = new SoftInfo(rs.getInt("soft_id"), rs.getInt("id"), rs.getString("soft_name"), null,
		                   rs.getString("genre_str"),null, rs.getString("model_str"),
		                   rs.getString("release_date"), rs.getString("price"), rs.getString("url"));
                list.add(u);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public SoftInfo findById(UserInfo loginUser) {

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID)) {

            stmt.setInt(1, loginUser.getId());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	SoftInfo soft = new SoftInfo();
                return soft;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    public SoftInfo findBySoftName(String softName) {

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_SOFT_NAME)) {
            stmt.setString(1, softName);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                SoftInfo s = new SoftInfo();
            	s.setSoftName(rs.getString("soft_name"));
            	s.setGenreId(rs.getInt("genre_id"));
            	s.setGenreStr(rs.getString("genre_str"));
            	s.setModelId(rs.getInt("model_id"));
            	s.setModelStr(rs.getString("model_str"));
            	s.setReleaseDate(rs.getString("release_date"));
            	s.setPrice(rs.getString("price"));
            	s.setUrl(rs.getString("url"));

                return s;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    public void insert(SoftInfo softResister , UserInfo loginUser) {

    	try(PreparedStatement stmt = connection.prepareStatement(INSERT)){

    		stmt.setInt(1,loginUser.getId());
    		stmt.setString(2,softResister.getSoftName());
    		stmt.setInt(3,softResister.getGenreId());
    		stmt.setInt(4,softResister.getModelId());
    		stmt.setString(5,softResister.getReleaseDate());
    		stmt.setString(6,softResister.getPrice());
    		stmt.setString(7, softResister.getUrl());
    		stmt.executeUpdate();

    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}
    }

    public void update(SoftInfo softUpdate , UserInfo loginUser) {

        try (PreparedStatement stmt = connection.prepareStatement(UPDATE)) {
            stmt.setString(1, softUpdate.getSoftName());
            stmt.setInt(2, softUpdate.getGenreId());
            stmt.setInt(3, softUpdate.getModelId());
            stmt.setString(4, softUpdate.getReleaseDate());
            stmt.setString(5, softUpdate.getPrice());
            stmt.setString(6, softUpdate.getUrl());
            stmt.setString(7, softUpdate.getSoftName());
            stmt.setInt(8, loginUser.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(UserInfo loginUser) {

        try (PreparedStatement stmt = connection.prepareStatement(DELETE_BY_ID)) {

            stmt.setInt(1, loginUser.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void deleteByIdAndSoftName(UserInfo loginUser, SoftInfo deleteSoft) {

        try (PreparedStatement stmt = connection.prepareStatement(DELETE_BY_SOFT_NAME_AND_ID)) {

            stmt.setString(1, deleteSoft.getSoftName());
            stmt.setInt(2, loginUser.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

