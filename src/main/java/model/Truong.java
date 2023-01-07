package model;

public class Truong {
	protected String ma_truong;
	protected String ten_truong;
	protected String dia_chi;
	protected String so_dien_thoai;
	
	public Truong() {
		super();
	}

	public Truong(String ma_truong, String ten_truong, String dia_chi, String so_dien_thoai) {
		super();
		this.ma_truong = ma_truong;
		this.ten_truong = ten_truong;
		this.dia_chi = dia_chi;
		this.so_dien_thoai = so_dien_thoai;
	}
	
	public String getMa_truong() {
		return ma_truong;
	}
	public void setMa_truong(String ma_truong) {
		this.ma_truong = ma_truong;
	}
	public String getTen_truong() {
		return ten_truong;
	}
	public void setTen_truong(String ten_truong) {
		this.ten_truong = ten_truong;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	
	
}
