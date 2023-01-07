package model;

public class Nganh {
	protected String ma_nganh;
	protected String ten_nganh;
	protected String loai_nganh;
	
	public Nganh() {
		super();
	}
	
	public Nganh(String ma_nganh, String ten_nganh, String loai_nganh) {
		super();
		this.ma_nganh = ma_nganh;
		this.ten_nganh = ten_nganh;
		this.loai_nganh = loai_nganh;
	}
	
	public String getMa_nganh() {
		return ma_nganh;
	}
	public void setMa_nganh(String ma_nganh) {
		this.ma_nganh = ma_nganh;
	}
	public String getTen_nganh() {
		return ten_nganh;
	}
	public void setTen_nganh(String ten_nganh) {
		this.ten_nganh = ten_nganh;
	}
	public String getLoai_nganh() {
		return loai_nganh;
	}
	public void setLoai_nganh(String loai_nganh) {
		this.loai_nganh = loai_nganh;
	}
	
	
}
