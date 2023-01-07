package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TotNghiep;

public class TotNghiepDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3366/javaweb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT = "INSERT INTO totnghiep" + " (so_cmnd, ma_truong, ma_nganh, he_tot_nghiep, ngay_tot_nghiep, loai_tot_nghiep) VALUES (?, ?, ?, ?, ?, ?);";
	private static final String SELECT = "select * from totnghiep where so_cmnd = ?;";
	private static final String SELECT_ALL = "select * from totnghiep;";

	public TotNghiepDAO() { }
	
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

	public void insert(TotNghiep i) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			preparedStatement.setString(1, i.getSo_cmnd());
			preparedStatement.setString(2, i.getMa_truong());
			preparedStatement.setString(3, i.getMa_nganh());
			preparedStatement.setString(4, i.getHe_tot_nghiep());
			preparedStatement.setString(5, i.getNgay_tot_nghiep());
			preparedStatement.setString(6, i.getLoai_tot_nghiep());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public TotNghiep select(String id) {
		TotNghiep i = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String ma_truong = rs.getString("ma_truong");
				String ma_nganh = rs.getString("ma_nganh");
				String he_tot_nghiep = rs.getString("he_tot_nghiep");
				String ngay_tot_nghiep = rs.getString("ngay_tot_nghiep");
				String loai_tot_nghiep = rs.getString("loai_tot_nghiep");
				
				i = new TotNghiep(id, ma_truong, ma_nganh, he_tot_nghiep, ngay_tot_nghiep, loai_tot_nghiep);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

	public List<TotNghiep> selectAll() {
		List<TotNghiep> i = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String so_cmnd = rs.getString("so_cmnd");
				String ma_truong = rs.getString("ma_truong");
				String ma_nganh = rs.getString("ma_nganh");
				String he_tot_nghiep = rs.getString("he_tot_nghiep");
				String ngay_tot_nghiep = rs.getString("ngay_tot_nghiep");
				String loai_tot_nghiep = rs.getString("loai_tot_nghiep");
				
				i.add(new TotNghiep(so_cmnd, ma_truong, ma_nganh, he_tot_nghiep, ngay_tot_nghiep, loai_tot_nghiep));
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

}
