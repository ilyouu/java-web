package model;

public class SinhVien {
	protected String so_cmnd;
	protected String ten;
	protected String email;
	protected String so_dien_thoai;
	protected String dia_chi;
	
	public SinhVien() {
		super();
	}

	public SinhVien(String so_cmnd, String ten, String email, String so_dien_thoai, String dia_chi) {
		super();
		this.so_cmnd = so_cmnd;
		this.ten = ten;
		this.email = email;
		this.so_dien_thoai = so_dien_thoai;
		this.dia_chi = dia_chi;
	}

	public String getSo_cmnd() {
		return so_cmnd;
	}

	public void setSo_cmnd(String so_cmnd) {
		this.so_cmnd = so_cmnd;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}

	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	
	
}
