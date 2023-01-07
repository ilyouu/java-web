CREATE DATABASE `javaweb`;

create table javaweb.truong (
    ma_truong varchar(20) NOT NULL,
    ten_truong varchar(50) not null,
    dia_chi varchar(50) not null,
    so_dien_thoai varchar(12) not null,
    primary key (ma_truong)
);

create table javaweb.nganh (
    ma_nganh varchar(20) NOT NULL,
    ten_nganh varchar(50) not null,
    loai_nganh varchar(30) not null,
    primary key (ma_nganh)
);

create table javaweb.sinhvien (
    so_cmnd varchar(20) NOT NULL,
    ten varchar(50) not null,
    email varchar(50) not null,
    so_dien_thoai varchar(12) not null,
    dia_chi varchar(50) not null,
    primary key (so_cmnd)
);

create table javaweb.totnghiep (
    so_cmnd varchar(20) NOT NULL,
    ma_truong varchar(20) NOT NULL,
    ma_nganh varchar(20) NOT NULL,
    he_tot_nghiep varchar(30) not null,
	ngay_tot_nghiep varchar(30) not null,
	loai_tot_nghiep varchar(30) not null,
    primary key (so_cmnd, ma_truong, ma_nganh),
    FOREIGN KEY (so_cmnd) REFERENCES javaweb.sinhvien(so_cmnd),
    FOREIGN KEY (ma_truong) REFERENCES javaweb.truong(ma_truong),
    FOREIGN KEY (ma_nganh) REFERENCES javaweb.nganh(ma_nganh)
);

create table javaweb.congviec (
    so_cmnd varchar(20) NOT NULL,
    ngay_vao_cong_ty varchar(20) not null,
    ma_nganh varchar(20) NOT NULL,
    ten_cong_viec varchar(12) not null,
	ten_cong_ty varchar(12) not null,
	dia_chi_cong_ty varchar(12) not null,
	thoi_gian_lam_viec varchar(12) not null,
    primary key (so_cmnd, ngay_vao_cong_ty),
    FOREIGN KEY (so_cmnd) REFERENCES javaweb.sinhvien(so_cmnd),
    FOREIGN KEY (ma_nganh) REFERENCES javaweb.nganh(ma_nganh)
);

