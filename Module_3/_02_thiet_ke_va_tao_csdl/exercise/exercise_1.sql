1 . Các thực thể có trong mô hình ERD
	- Phieu Xuat
    - Vat tu
    - Phieu nhạp
    - Don dat hang
    - Nha cung cap
2. Các mối quan hệ 
	a. n-n
		- giữa thực thể (PHIEU XUAT) và  (VATTU)
			+ PHIEUXUAT (SoPX,NgayXuat)
            + VATTU (MaVTU, TenVTU)
            + CHITIETPHIEUXUAT(SoPX,MaVTU,DGXuat,SLXuat)
		- Giữa thực thể VATTU và PHIEUNHAP
			+ PHIEUNHAP(SoPN,NgayNhap)
            + CHITIETPHIEUNHAP(SoPN,MaVTU,DGNhap,SLNhap)
		- Giữa VATTU và DONDH 
			+ DONDH(SoDH,NgayDH)
            + CHITIETDONDATHANG(SoDH,MaVTU)
	b. 1-n
		- Giữa thực thể DONDH và NHACC
			+ DONDH(SoDH,NgayDH,MaNCC)
            + NHACC(MaNCC,TenNCC,DiaChi,SĐT)
3. Danh sách các bảng sau khi chuyển đổi
	PHIEUXUAT(SoPX,NgayXuat)
	VATTU(MaVTU,TenVTU)
	CHITIETPHIEUXUAT(SoPX,MaVTU,DGXuat,SLXuat)
	PHIEUNHAP(SoPN,NgayNhap)
	CHITIETPHIEUNHAP(SoPN,MaVTU,DGNhap,SLNhap)
	DONDH(SoDH,NgayDH)
	CHITIETDONDATHANG(SoDH,MaVTU)
	DONDH(SoDH,NgayDH,MaNCC)
	NHACC(MaNCC,TenNCC,DiaChi,SĐT)

