-- 21.Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view v_nhanvien
as 
select nv.id_nhan_vien,ho_ten,ngay_lam_hop_dong,dia_chi
from nhan_vien nv
join hop_dong hd on hd.id_nhan_vien = nv.id_nhan_vien
where dia_chi = 'Hải Châu' and ngay_lam_hop_dong = '2019-12-12';
-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhanvien
set dia_chi = 'Liên Chiểu';
-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
delimiter //
create procedure sp_1(in p_id_khach_hang int)
begin
	delete from khach_hang
    where id_khach_hang = p_id_khach_hang;
end;
// delimiter ;
call sp_1(6);
-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
--  với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create procedure sp_2(p_id_nhan_vien int, p_id_khach_hang int, p_id_dich_vu int, p_ngay_lam_hop_dong date, p_ngay_ket_thuc date, p_tien_dat_coc int)
begin
	if ( (p_id_nhan_vien in (select id_nhan_vien from nhan_vien)) and (p_id_khach_hang in (select id_khach_hang from khach_hang)) 
			and (p_id_dich_vu in (select id_dich_vu from dich_vu)) ) then
            insert into hop_dong (id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc)
            values (p_id_nhan_vien,p_id_khach_hang,p_id_dich_vu,p_ngay_lam_hop_dong,p_ngay_ket_thuc,p_tien_dat_coc);
    else
		select 'Sai thông tin, vui lòng nhập lại';
	end if;
end;
// delimiter ;
call sp_2(2,2,2,'2020-10-20','2020-10-21',50);
call sp_2(10,10,10,'2020-10-20','2020-10-21',50);
-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database

-- 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, 
-- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, 
-- nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database

-- 27.	Tạo user function thực hiện yêu cầu sau:
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.

-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ 
-- (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
-- Mã của Khách hàng được truyền vào như là 1 tham số của function này.

-- 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó 
-- (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.
