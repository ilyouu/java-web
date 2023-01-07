package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SinhVien;

public class SinhVienDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3366/javaweb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT = "INSERT INTO sinhvien" + " (so_cmnd, so_cmnd, email, so_dien_thoai, dia_chi) VALUES (?, ?, ?, ?, ?);";
	private static final String SELECT = "select * from sinhvien where so_cmnd = ?;";
	private static final String SELECT_ALL = "select * from sinhvien;";

	public SinhVienDAO() { }
	
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

	public void insert(SinhVien i) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			preparedStatement.setString(1, i.getSo_cmnd());
			preparedStatement.setString(2, i.getTen());
			preparedStatement.setString(3, i.getEmail());
			preparedStatement.setString(4, i.getSo_dien_thoai());
			preparedStatement.setString(5, i.getDia_chi());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public SinhVien select(String id) {
		SinhVien i = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				String dia_chi = rs.getString("dia_chi");
				
				i = new SinhVien(id, ten, email, so_dien_thoai, dia_chi);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

	public List<SinhVien> selectAll() {
		List<SinhVien> i = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String so_cmnd = rs.getString("so_cmnd");
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String so_dien_thoai = rs.getString("so_dien_thoai");
				String dia_chi = rs.getString("dia_chi");
				
				i.add(new SinhVien(so_cmnd, ten, email, so_dien_thoai, dia_chi));
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

}
