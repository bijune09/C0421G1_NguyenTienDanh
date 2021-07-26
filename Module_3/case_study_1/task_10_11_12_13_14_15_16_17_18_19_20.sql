-- 11.Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dvdk.id_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, kh.ho_ten, kh.dia_chi, lk.ten_loai_khach
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on  dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
join hop_dong hd on hd.id_hop_dong = hdct.id_hop_dong
join khach_hang kh on kh.id_khach_hang = hd.id_khach_hang
join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
where ten_loai_khach = 'Diamond' and (dia_chi = 'Quảng Ngãi' or dia_chi = 'Vinh');
-- dia_chi in ('Quảng Ngãi, 'Vinh')
-- 12.Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hd.id_hop_dong,nv.ho_ten,kh.ho_ten,kh.sdt,dv.ten_dich_vu,hdct.so_luong,hd.tien_dat_coc
from hop_dong hd
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join nhan_vien nv on nv.id_nhan_vien = hd.id_nhan_vien
where hd.ngay_lam_hop_dong in 
	(select hd.ngay_lam_hop_dong
	from hop_dong hd 
    where (year(ngay_lam_hop_dong) = 2019 and month(ngay_lam_hop_dong) in (10,11,12)))
    and hd.ngay_lam_hop_dong not in 
	(select hd.ngay_lam_hop_dong
	from hop_dong hd 
   where (year(ngay_lam_hop_dong) = 2019 and month(ngay_lam_hop_dong) in (1,2,3,4,5,6,7,8,9)));
-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.id_dich_vu_di_kem,ten_dich_vu_di_kem,dvdk.gia,don_vi, sum(so_luong) as 'so_lan_su_dung'
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
order by so_lan_su_dung desc
limit 1;
-- 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select dvdk.id_dich_vu_di_kem,ten_dich_vu_di_kem,dvdk.gia,don_vi, sum(so_luong) as 'so_lan_su_dung'
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
having sum(so_luong) = 1;
-- 15.Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nv.id_nhan_vien,nv.ho_ten,td.trinh_do,bp.ten_bo_phan,nv.dia_chi,hd.ngay_lam_hop_dong, count(hd.id_hop_dong) as 'so_lan_lap_hop_dong'
from nhan_vien nv
join hop_dong hd on hd.id_nhan_vien = nv.id_nhan_vien
join trinh_do td on td.id_trinh_do = nv.id_trinh_do
join bo_phan bp on bp.id_bo_phan = nv.id_bo_phan
where (year(hd.ngay_lam_hop_dong) in (2018,2019))
group by nv.id_nhan_vien
having so_lan_lap_hop_dong >= 3;
-- 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
create temporary table temp_table
(select nv.id_nhan_vien
from nhan_vien nv 
left join hop_dong hd on hd.id_nhan_vien = nv.id_nhan_vien
where year(ngay_lam_hop_dong) in (2017,2018,2019) or hd.id_hop_dong is null);

delete from nhan_vien
where id_nhan_vien not in(select * from temp_table);

drop temporary table temp_table;
-- 17.Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
create temporary table temp_table 
(select sum(dv.chi_phi_thue+(hdct.so_luong*dvdk.gia)) as 'tong'
from khach_hang kh
join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
where year(ngay_lam_hop_dong) = 2019 and kh.id_loai_khach = 2
group by hd.id_khach_hang
having tong>500);

update khach_hang
set id_loai_khach = 1
where id_khach_hang in 
(select * from temp_table);

drop temporary table temp_table;
-- 18.Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
create temporary table temp_table
(select kh.id_khach_hang
from khach_hang kh
join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
where year(ngay_lam_hop_dong) = 2016);

delete from khach_hang
where id_khach_hang in (select * from temp_table);

drop temporary table temp_table;
-- 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
create temporary table temp_table(
select hdct.id_dich_vu_di_kem 'id_dich_vu_di_kem', sum(so_luong) as 'so_lan_su_dung'
from hop_dong_chi_tiet hdct
join hop_dong hd on hd.id_hop_dong = hdct.id_hop_dong
join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
where year(ngay_lam_hop_dong) = 2019
group by dvdk.id_dich_vu_di_kem
having so_lan_su_dung > 10);

update dich_vu_di_kem
set gia = (gia*2)
where id_dich_vu_di_kem in ( select id_dich_vu_di_kem from temp_table);

drop temporary table temp_table;
-- 20.Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
-- ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select id_nhan_vien,ho_ten,email,sdt,ngay_sinh,dia_chi 
from nhan_vien
union 
select id_khach_hang,ho_ten,email,sdt,ngay_sinh,dia_chi
from khach_hang