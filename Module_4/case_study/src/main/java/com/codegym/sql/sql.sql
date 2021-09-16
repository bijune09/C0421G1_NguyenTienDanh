INSERT INTO attach_service(`name`, cost,unit,`status`)
VALUES ('Massage', 100000, 'Lượt', 'Khả dụng'),
		('Karaoke', 250000, 'Giờ', 'Khả dụng'),
        ('Thức ăn', 50000, 'Phần', 'Khả dụng'),
        ('Nước uống', 10000, 'Chai', 'Khả dụng'),
        ('Thuê xe tham quan resort', 150000, 'Xe', 'Khả dụng');
-- 
INSERT INTO service_type(`name`)
VALUES ('Villa'),
		('House'),
        ('Room');
-- 
INSERT INTO `position`(`name`)
VALUES ('Lễ tân'),
		('Phục vụ'),
        ('Chuyên viên'),
        ('Giám sát'),
        ('Quản lý'),
        ('Giám đốc');
--
INSERT INTO education_degree(`name`)
VALUES ('Trung cấp'),
		('Cao đẳng'),
		('Đại học'),
		('Sau đại học');
--
INSERT INTO division(`name`)
VALUES ('Sale-Marketing'),
		('Hành chính'),
		('Phục vụ'),
		('Quản lý');
--
INSERT INTO customer_type(`name`)
VALUES ('Diamond'),
		('Platinium'),
        ('Gold'),
        ('Silver'),
        ('Member');
--
INSERT INTO customer(customer_type_id, `name`, birthday, gender, id_card, phone, email, address,`code`)
VALUES (5, 'Minh', '2020-10-06',1,201562744, 0843670087, 'minh@gmail.com', 'Đà Nẵng','KH-0001'),
		(1, 'Danh', '1997-08-22',1,201684297, 0394581627, 'danh@gmail.com', 'Huế','KH-0002'),
		(1, 'Toàn', '1994-11-11',1,201251983, 0871555364, 'toan@gmail.com', 'Vinh','KH-0003'),
		(2, 'Uyên', '1996-01-28',0,201523799, 0177646469, 'uyen@gmail.com', 'Quảng Trị','KH-0004'),
		(4, 'Hiền', '1997-07-17',0,201588114, 0111346999, 'hien@gmail.com', 'Đà Nẵng','KH-0005'),
		(1, 'Tiến', '1993-09-17',1,201599988, 0111312999, 'tien@gmail.com', 'Đà Nẵng','KH-0006');
--
INSERT INTO employee(`name`, position_id, education_degree_id, division_id, birthday,id_card, salary, phone, email, address)
VALUES ('Lâm', 2, 3, 3, '1998-10-16', 201757954, 10000, 0825161098, 'lam@gmail.com', 'Đà Nẵng'),
		('Khoa', 1, 1, 3, '2000-05-11', 201751546, 5000, 0917657904, 'khoa@gmail.com', 'Huế'),
		('Tùng', 5, 4, 4, '1992-03-18', 201718628, 35000, 0818467035, 'tung@gmail.com', 'Vinh'),
		('Huy', 6, 4, 2, '1991-12-12', 201792127, 50000, 0818467035, 'thanh@gmail.com', 'Quảng Trị');
--
INSERT INTO service(`name`, area, floor, capacity, cost, rent_type_id, service_type_id, `description`,standard,pool_area)
VALUES ('Ocean Villa', 100, 3, 10, 5000000, 2, 1, 'Khả dụng','TCVN',30),
		('Sand Room', 25, NULL, 2, 600000, 3, 3, 'Khả dụng','TCVN',null),
        ('Wind House', 70, 2, 5, 3000000, 3, 2, 'Khả dụng','TCVN',null);
--
INSERT INTO contract(employee_id, customer_id, service_id, start_date, end_date, deposit)
VALUES (2, 2, 3, '2021-07-14', '2021-08-11', 50000),
		(1, 2, 1, '2021-01-24', '2021-09-02', 50000),
		(4, 6, 1, '2019-04-30', '2019-09-02', 50000),
		(3, 1, 1, '2018-06-29', '2018-12-19', 70000),
		(4, 3, 2, '2021-03-17', '2021-10-16', 90000);
--
INSERT INTO contract_detail(contract_id, attach_service_id, quantity)
VALUES (1, 3, 5),
		(2, 1, 2),
        (3, 5, 3),
        (5, 4, 2);