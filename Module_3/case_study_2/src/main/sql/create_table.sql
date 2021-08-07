drop database if exists case_study;
create database case_study;
use case_study;

create table vai_tro(
  id_vai_tro int auto_increment primary key,
  ten_vai_tro varchar(50)
);

create table tai_khoan (
	ten_tai_khoan varchar(50) primary key,
    mat_khau varchar(50)
);

create table vai_tro_tai_khoan (
	id_vai_tro int,
    ten_tai_khoan varchar(50),
    
    primary key(id_vai_tro,ten_tai_khoan),
    foreign key (id_vai_tro) references vai_tro(id_vai_tro) on update cascade on delete cascade,
    foreign key (ten_tai_khoan) references tai_khoan(ten_tai_khoan) on update cascade on delete cascade
);

create table vi_tri(
	id_vi_tri int auto_increment primary key,
    ten_vi_tri varchar(50)
);

create table trinh_do(
	id_trinh_do int auto_increment primary key,
    trinh_do varchar(50)
);

create table bo_phan(
	id_bo_phan int auto_increment primary key,
    ten_bo_phan varchar(50)
);

create table nhan_vien(
	id_nhan_vien int auto_increment primary key,
    ho_ten varchar(50),
    id_vi_tri int,
    id_trinh_do int,
    id_bo_phan int,
    ngay_sinh date,
    so_CMTND varchar(50),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    ten_tai_khoan varchar(50),
    
    foreign key (id_vi_tri) references vi_tri(id_vi_tri) on update cascade on delete cascade,
    foreign key (id_trinh_do) references trinh_do(id_trinh_do) on update cascade on delete cascade,
    foreign key (id_bo_phan) references bo_phan(id_bo_phan) on update cascade on delete cascade,
    foreign key (ten_tai_khoan) references tai_khoan(ten_tai_khoan)on update cascade on delete cascade
);

create table loai_khach (
	id_loai_khach int auto_increment primary key,
    ten_loai_khach varchar(50)
);

create table khach_hang (
	id_khach_hang int auto_increment primary key,
    id_loai_khach int,
    ho_ten varchar(50),
    ngay_sinh date,
    so_CMTND varchar(50),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    foreign key (id_loai_khach) references loai_khach(id_loai_khach) on update cascade on delete cascade
);

create table loai_dich_vu (
	id_loai_dich_vu int auto_increment primary key,
    ten_loai_dich_vu varchar(50)
);

create table kieu_thue (
	id_kieu_thue int auto_increment primary key,
    ten_kieu_thue varchar (50)
);

create table dich_vu (
	id_dich_vu int auto_increment primary key,
    ten_dich_vu varchar(50),
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da int,
    chi_phi_thue int,
    id_kieu_thue int,
    id_loai_dich_vu int,
    trang_thai varchar(50),
    foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue) on update cascade on delete cascade,
    foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu) on update cascade on delete cascade
);

create table hop_dong (
	id_hop_dong int auto_increment primary key ,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_dat_coc int,
    foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien) on update cascade on delete cascade,
    foreign key (id_khach_hang) references khach_hang(id_khach_hang) on update cascade on delete cascade,
    foreign key (id_dich_vu) references dich_vu(id_dich_vu) on update cascade on delete cascade
);

create table dich_vu_di_kem (
	id_dich_vu_di_kem int auto_increment primary key,
    ten_dich_vu_di_kem varchar(50),
    gia int,
    don_vi varchar(50),
    trang_thai_kha_dung varchar(50)
);

create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int auto_increment primary key,
    id_hop_dong int,
    id_dich_vu_di_kem int,
    so_luong int,
    foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem) on update cascade on delete cascade,
    foreign key (id_hop_dong) references hop_dong(id_hop_dong) on update cascade on delete cascade
);

INSERT INTO vi_tri(ten_vi_tri)
VALUES ('Lễ tân'),
		('Phục vụ'),
        ('Chuyên viên'),
        ('Giám sát'),
        ('Quản lý'),
        ('Giám đốc');
        
INSERT INTO trinh_do(trinh_do)
VALUES ('Trung cấp'),
		('Cao đẳng'),
		('Đại học'),
		('Sau đại học');
        
INSERT INTO bo_phan(ten_bo_phan)
VALUES ('Sale-Marketing'),
		('Hành chính'),
		('Phục vụ'),
		('Quản lý');
        
INSERT INTO loai_khach(ten_loai_khach)
VALUES ('Diamond'),
		('Platinium'),
        ('Gold'),
        ('Silver'),
        ('Member');
INSERT INTO dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung)
VALUES ('Massage', 100000, 'Lượt', 'Khả dụng'),
		('Karaoke', 250000, 'Giờ', 'Khả dụng'),
        ('Thức ăn', 50000, 'Phần', 'Khả dụng'),
        ('Nước uống', 10000, 'Chai', 'Khả dụng'),
        ('Thuê xe tham quan resort', 150000, 'Xe', 'Khả dụng');
        
INSERT INTO loai_dich_vu(ten_loai_dich_vu)
VALUES ('Villa'),
		('House'),
        ('Room');

INSERT INTO kieu_thue(ten_kieu_thue)
VALUES ('Năm'),
		('Tháng'),
        ('Ngày'),
        ('Giờ');


