package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Nganh;

public class NganhDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3366/javaweb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT = "INSERT INTO nganh" + " (ma_nganh, ten_nganh, loai_nganh) VALUES (?, ?, ?);";
	private static final String SELECT = "select * from nganh where ma_nganh = ?;";
	private static final String SELECT_ALL = "select * from nganh;";

	public NganhDAO() { }
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insert(Nganh i) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			preparedStatement.setString(1, i.getMa_nganh());
			preparedStatement.setString(2, i.getTen_nganh());
			preparedStatement.setString(3, i.getLoai_nganh());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public Nganh select(String id) {
		Nganh i = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String ten_nganh = rs.getString("ten_nganh");
				String loai_nganh = rs.getString("loai_nganh");
				
				i = new Nganh(id, ten_nganh, loai_nganh);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

	public List<Nganh> selectAll() {
		List<Nganh> i = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String ma_nganh = rs.getString("ma_nganh");
				String ten_nganh = rs.getString("ten_nganh");
				String loai_nganh = rs.getString("loai_nganh");
				
				i.add(new Nganh(ma_nganh, ten_nganh, loai_nganh));
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

}
