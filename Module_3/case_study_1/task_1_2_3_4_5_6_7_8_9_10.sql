use case_study;
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select *
from nhan_vien
where (ho_ten like 'h%' or ho_ten like 't%' or ho_ten like 'k%') and length(ho_ten) <= 15;
-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where (dia_chi = "Đà Nẵng" or dia_chi = "Quảng Trị") 
and ( year(curdate())-year(ngay_sinh) >=18 and year(curdate())-year(ngay_sinh)<=50);
-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- 	Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select hd.id_khach_hang,kh.ho_ten,lk.ten_loai_khach, count(hd.id_hop_dong) as 'so_lan_dat' 
from hop_dong hd
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
where lk.ten_loai_khach = 'Diamond'
group by hd.id_khach_hang
order by so_lan_dat;
-- 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- 	(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng.
-- 	(Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.id_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.id_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
sum(dv.chi_phi_thue+(hdct.so_luong*dvdk.gia)) as 'tong_tien'
from khach_hang kh 
left join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
left join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
left join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
left join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
left join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by kh.id_khach_hang
order by tong_tien;
-- 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện
-- đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select hd.id_hop_dong, dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu,hd.ngay_lam_hop_dong
from dich_vu dv
left join loai_dich_vu ldv on ldv.id_loai_dich_vu = dv.id_loai_dich_vu
left join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
where hd.ngay_lam_hop_dong not in 
( 	select hd.ngay_lam_hop_dong
	from hop_dong hd 
    where (year(ngay_lam_hop_dong) = 2019 and month(ngay_lam_hop_dong) in (1,2,3))
);
-- 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019
select hd.id_hop_dong, dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on ldv.id_loai_dich_vu = dv.id_loai_dich_vu
left join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
where hd.ngay_lam_hop_dong not in 
	( 	select hd.ngay_lam_hop_dong
	from hop_dong hd 
    where (year(ngay_lam_hop_dong) = 2019))
and hd.ngay_lam_hop_dong in 
( 	select hd.ngay_lam_hop_dong
	from hop_dong hd 
    where (year(ngay_lam_hop_dong) = 2018));
-- 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
select distinct ho_ten
from khach_hang;

select ho_ten
from khach_hang
group by id_khach_hang;

-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select *, count(id_khach_hang) as 'so_lan_dat'
from hop_dong
where year(ngay_lam_hop_dong) = 2019
group by month(ngay_lam_hop_dong);
-- 10.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select hd.id_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc, count(hdct.id_dich_vu_di_kem) as 'so_luong_dich_vu_di_kem'
from hop_dong_chi_tiet hdct
join dich_vu_di_kem dv on hdct.id_dich_vu_di_kem = dv.id_dich_vu_di_kem
join hop_dong hd on hd.id_hop_dong = hdct.id_hop_dong
group by ten_dich_vu_di_kem;