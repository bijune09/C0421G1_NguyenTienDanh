drop database if exists demo;
create database demo;
use demo;
create table products (
	id int primary key auto_increment,
    product_code varchar(10),
    product_name varchar(20),
    product_price int,
    product_amount int,
    product_decription varchar(50),
    product_status bit
);
insert into products (product_code,product_name,product_price,product_amount,product_decription,product_status)
values ('PD-001','Iphone X',5,5,'Meh',1),
('PD-002','Iphone 11',5,5,'Meh',1),
('PD-003','Iphone 12',5,5,'Meh',1),
('PD-004','SamSung',5,5,'Meh',1);
--
explain select * from products where product_code = 'PD-003';
alter table products add unique idx_product_code (product_code);
explain select * from products where product_code = 'PD-003';
--
explain select * from products where product_name = 'SamSung' and product_price = '5';
alter table products add index composite(product_name,product_price);
explain select * from products where product_name = 'SamSung' and product_price = '5';
--
create view product_view as
select product_code,product_name,product_price,product_status
from products;
--
create or replace view product_view as
select product_code,product_name
from products;
--
drop view product_view;
--
delimiter //
create procedure get_all_products()
BEGIN 
	select *
    from products;
end;
// delimiter ;
call get_all_products();
--
delimiter //
create procedure add_new_product
(in p_product_code varchar(10),in p_product_name varchar(20),in p_product_price int,in p_product_amount int,in p_product_decription varchar(50),in p_product_status bit)
BEGIN 
  insert into products (product_code,product_name,product_price,product_amount,product_decription,product_status)
  values (p_product_code,p_product_name,p_product_price,p_product_amount,p_product_decription,p_product_status);
end;
// delimiter ;
call add_new_product('PD-005','Black Berry',5,5,'Erm',1);
call get_all_products();
--
delimiter //
create procedure edit_product(in p_id int, in p_product_status int)
BEGIN 
	update products
    set product_status = p_product_status
    where id = p_id;
end;
// delimiter ;
call edit_product(1,0);
call get_all_products();
--
delimiter //
create procedure delete_product(in p_id int)
BEGIN 
	delete from products
    where id = p_id;
end;
// delimiter ;
call delete_product(3);
call get_all_products();