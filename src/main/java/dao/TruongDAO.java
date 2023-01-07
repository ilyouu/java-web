package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Truong;

public class TruongDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3366/javaweb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT = "INSERT INTO truong" + " (ma_truong, ten_truong, dia_chi, so_dien_thoai) VALUES (?, ?, ?, ?);";
	private static final String SELECT = "select * from truong where ma_truong = ?;";
	private static final String SELECT_ALL = "select * from truong;";

	public TruongDAO() { }
	
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

	public void insert(Truong i) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			preparedStatement.setString(1, i.getMa_truong());
			preparedStatement.setString(2, i.getTen_truong());
			preparedStatement.setString(3, i.getDia_chi());
			preparedStatement.setString(4, i.getSo_dien_thoai());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public Truong select(String id) {
		Truong i = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String ten_truong = rs.getString("ten_truong");
				String dia_chi = rs.getString("dia_chi");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				
				i = new Truong(id, ten_truong, dia_chi, so_dien_thoai);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

	public List<Truong> selectAll() {
		List<Truong> i = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String ma_truong = rs.getString("ma_truong");
				String ten_truong = rs.getString("ten_truong");
				String dia_chi = rs.getString("dia_chi");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				
				i.add(new Truong(ma_truong, ten_truong, dia_chi, so_dien_thoai));
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

}
