package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CongViec;

public class CongViecDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3366/javaweb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT = "INSERT INTO congviec" + " (so_cmnd, ngay_vao_cong_ty, ma_nganh, ten_cong_viec, ten_cong_ty, dia_chi_cong_ty, thoi_gian_lam_viec) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT = "select * from congviec where so_cmnd = ?;";
	private static final String SELECT_ALL = "select * from congviec;";

	public CongViecDAO() { }
	
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

	public void insert(CongViec i) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			preparedStatement.setString(1, i.getSo_cmnd());
			preparedStatement.setString(2, i.getNgay_vao_cong_ty());
			preparedStatement.setString(3, i.getMa_nganh());
			preparedStatement.setString(4, i.getTen_cong_viec());
			preparedStatement.setString(5, i.getTen_cong_ty());
			preparedStatement.setString(6, i.getDia_chi_cong_ty());
			preparedStatement.setString(7, i.getThoi_gian_lam_viec());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public CongViec select(String id) {
		CongViec i = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String ngay_vao_cong_ty = rs.getString("ngay_vao_cong_ty");
				String ma_nganh = rs.getString("ma_nganh");
				String ten_cong_viec = rs.getString("ten_cong_viec");
				String ten_cong_ty = rs.getString("ten_cong_ty");
				String dia_chi_cong_ty = rs.getString("dia_chi_cong_ty");
				String thoi_gian_lam_viec = rs.getString("thoi_gian_lam_viec");
				
				i = new CongViec(id, ngay_vao_cong_ty, ma_nganh, ten_cong_viec, ten_cong_ty, dia_chi_cong_ty, thoi_gian_lam_viec);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

	public List<CongViec> selectAll() {
		List<CongViec> i = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String so_cmnd = rs.getString("so_cmnd");
				String ngay_vao_cong_ty = rs.getString("ngay_vao_cong_ty");
				String ma_nganh = rs.getString("ma_nganh");
				String ten_cong_viec = rs.getString("ten_cong_viec");
				String ten_cong_ty = rs.getString("ten_cong_ty");
				String dia_chi_cong_ty = rs.getString("dia_chi_cong_ty");
				String thoi_gian_lam_viec = rs.getString("thoi_gian_lam_viec");
				
				i.add(new CongViec(so_cmnd, ngay_vao_cong_ty, ma_nganh, ten_cong_viec, ten_cong_ty, dia_chi_cong_ty, thoi_gian_lam_viec));
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return i;
	}

}
