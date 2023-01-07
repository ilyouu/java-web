package model;

public class CongViec {
	protected String so_cmnd;
	protected String ngay_vao_cong_ty;
	protected String ma_nganh;
	protected String ten_cong_viec;
	protected String ten_cong_ty;
	protected String dia_chi_cong_ty;
	protected String thoi_gian_lam_viec;
	
	public CongViec() {
		super();
	}
	public CongViec(String so_cmnd, String ngay_vao_cong_ty, String ma_nganh, String ten_cong_viec, String ten_cong_ty,
			String dia_chi_cong_ty, String thoi_gian_lam_viec) {
		super();
		this.so_cmnd = so_cmnd;
		this.ngay_vao_cong_ty = ngay_vao_cong_ty;
		this.ma_nganh = ma_nganh;
		this.ten_cong_viec = ten_cong_viec;
		this.ten_cong_ty = ten_cong_ty;
		this.dia_chi_cong_ty = dia_chi_cong_ty;
		this.thoi_gian_lam_viec = thoi_gian_lam_viec;
	}
	public String getSo_cmnd() {
		return so_cmnd;
	}
	public void setSo_cmnd(String so_cmnd) {
		this.so_cmnd = so_cmnd;
	}
	public String getNgay_vao_cong_ty() {
		return ngay_vao_cong_ty;
	}
	public void setNgay_vao_cong_ty(String ngay_vao_cong_ty) {
		this.ngay_vao_cong_ty = ngay_vao_cong_ty;
	}
	public String getMa_nganh() {
		return ma_nganh;
	}
	public void setMa_nganh(String ma_nganh) {
		this.ma_nganh = ma_nganh;
	}
	public String getTen_cong_viec() {
		return ten_cong_viec;
	}
	public void setTen_cong_viec(String ten_cong_viec) {
		this.ten_cong_viec = ten_cong_viec;
	}
	public String getTen_cong_ty() {
		return ten_cong_ty;
	}
	public void setTen_cong_ty(String ten_cong_ty) {
		this.ten_cong_ty = ten_cong_ty;
	}
	public String getDia_chi_cong_ty() {
		return dia_chi_cong_ty;
	}
	public void setDia_chi_cong_ty(String dia_chi_cong_ty) {
		this.dia_chi_cong_ty = dia_chi_cong_ty;
	}
	public String getThoi_gian_lam_viec() {
		return thoi_gian_lam_viec;
	}
	public void setThoi_gian_lam_viec(String thoi_gian_lam_viec) {
		this.thoi_gian_lam_viec = thoi_gian_lam_viec;
	}
	
	
}
