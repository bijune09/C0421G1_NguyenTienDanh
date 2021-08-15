delimiter //
create procedure find_by_char(p_keyword varchar(5))
begin
	select id_nhan_vien, ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_CMTND, luong, sdt, email, dia_chi, ten_tai_khoan
    from nhan_vien
    where ho_ten like concat('%',p_keyword,'%');
end;
// delimiter ; 