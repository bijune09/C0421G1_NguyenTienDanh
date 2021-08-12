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
    gioi_tinh bit(1),
    so_CMTND varchar(50),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    ma_khach_hang varchar(50) unique,
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
    tieu_chuan varchar(50),
    dien_tich_ho_boi double,
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
INSERT INTO khach_hang(id_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_CMTND, sdt, email, dia_chi,ma_khach_hang)
VALUES (5, 'Minh', '2020-10-06',1,201562744, 0843670087, 'minh@gmail.com', 'Đà Nẵng','KH-0001'),
		(1, 'Danh', '1997-08-22',1,201684297, 0394581627, 'danh@gmail.com', 'Huế','KH-0002'),
		(1, 'Toàn', '1994-11-11',1,201251983, 0871555364, 'toan@gmail.com', 'Vinh','KH-0003'),
		(2, 'Uyên', '1996-01-28',0,201523799, 0177646469, 'uyen@gmail.com', 'Quảng Trị','KH-0004'),
		(4, 'Hiền', '1997-07-17',0,201588114, 0111346999, 'hien@gmail.com', 'Đà Nẵng','KH-0005'),
		(1, 'Tiến', '1993-09-17',1,201599988, 0111312999, 'tien@gmail.com', 'Đà Nẵng','KH-0006');

INSERT INTO nhan_vien(ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh,so_CMTND, luong, sdt, email, dia_chi)
VALUES ('Lâm', 2, 3, 3, '1998-10-16', 201757954, 10000, 0825161098, 'lam@gmail.com', 'Đà Nẵng'),
		('Khoa', 1, 1, 3, '2000-05-11', 201751546, 5000, 0917657904, 'khoa@gmail.com', 'Huế'),
		('Tùng', 5, 4, 4, '1992-03-18', 201718628, 35000, 0818467035, 'tung@gmail.com', 'Vinh'),
		('Huy', 6, 4, 2, '1991-12-12', 201792127, 50000, 0818467035, 'thanh@gmail.com', 'Quảng Trị');
        
INSERT INTO dich_vu(ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, trang_thai,tieu_chuan,dien_tich_ho_boi)
VALUES ('Ocean Villa', 100, 3, 10, 5000000, 2, 1, 'Khả dụng','TCVN',30),
		('Sand Room', 25, NULL, 2, 600000, 3, 3, 'Khả dụng','TCVN',null),
        ('Wind House', 70, 2, 5, 3000000, 3, 2, 'Khả dụng','TCVN',null);
        
INSERT INTO dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung)
VALUES ('Massage', 100000, 'Lượt', 'Khả dụng'),
		('Karaoke', 250000, 'Giờ', 'Khả dụng'),
        ('Thức ăn', 50000, 'Dĩa', 'Khả dụng'),
        ('Nước uống', 10000, 'Chai', 'Khả dụng'),
        ('Thuê xe tham quan resort', 150000, 'Xe', 'Khả dụng');
        
INSERT INTO hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc)
VALUES (2, 2, 3, '2021-07-14', '2021-08-11', 50000),
		(1, 2, 1, '2021-01-24', '2021-09-02', 50000),
		(4, 6, 1, '2019-04-30', '2019-09-02', 50000),
		(3, 1, 1, '2018-06-29', '2018-12-19', 70000),
		(4, 3, 2, '2021-03-17', '2021-10-16', 90000);
        
INSERT INTO hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong)
VALUES (1, 3, 5),
		(2, 1, 2),
        (3, 5, 3),
        (5, 4, 2);


