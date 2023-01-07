package model;

public class TotNghiep {
	protected String so_cmnd;
	protected String ma_truong;
	protected String ma_nganh;
	protected String he_tot_nghiep;
	protected String ngay_tot_nghiep;
	protected String loai_tot_nghiep;
	
	public TotNghiep() {
		super();
	}
	public TotNghiep(String so_cmnd, String ma_truong, String ma_nganh, String he_tot_nghiep, String ngay_tot_nghiep,
			String loai_tot_nghiep) {
		super();
		this.so_cmnd = so_cmnd;
		this.ma_truong = ma_truong;
		this.ma_nganh = ma_nganh;
		this.he_tot_nghiep = he_tot_nghiep;
		this.ngay_tot_nghiep = ngay_tot_nghiep;
		this.loai_tot_nghiep = loai_tot_nghiep;
	}
	public String getSo_cmnd() {
		return so_cmnd;
	}
	public void setSo_cmnd(String so_cmnd) {
		this.so_cmnd = so_cmnd;
	}
	public String getMa_truong() {
		return ma_truong;
	}
	public void setMa_truong(String ma_truong) {
		this.ma_truong = ma_truong;
	}
	public String getMa_nganh() {
		return ma_nganh;
	}
	public void setMa_nganh(String ma_nganh) {
		this.ma_nganh = ma_nganh;
	}
	public String getHe_tot_nghiep() {
		return he_tot_nghiep;
	}
	public void setHe_tot_nghiep(String he_tot_nghiep) {
		this.he_tot_nghiep = he_tot_nghiep;
	}
	public String getNgay_tot_nghiep() {
		return ngay_tot_nghiep;
	}
	public void setNgay_tot_nghiep(String ngay_tot_nghiep) {
		this.ngay_tot_nghiep = ngay_tot_nghiep;
	}
	public String getLoai_tot_nghiep() {
		return loai_tot_nghiep;
	}
	public void setLoai_tot_nghiep(String loai_tot_nghiep) {
		this.loai_tot_nghiep = loai_tot_nghiep;
	}
	
	
}
