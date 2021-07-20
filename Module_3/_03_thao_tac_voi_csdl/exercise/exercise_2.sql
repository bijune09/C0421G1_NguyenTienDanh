drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer (
	customer_id int auto_increment not null primary key,
    customer_name varchar(50) not null,
    customer_age int check (customer_age between 18 and 100)
);
create table `order` (
	order_id int auto_increment not null primary key,
    customer_id int not null ,
    order_date datetime not null,
    order_price float ,
    foreign key (customer_id) references customer(customer_id)
);
create table product (
	product_id int auto_increment not null primary key,
    product_name varchar(30) not null,
    product_price float not null
);
create table order_details (
	order_id int not null ,
    product_id int not null ,
    order_quantity int not null,
    primary key (order_id, product_id),
	foreign key (order_id) references `order`(order_id),
    foreign key (product_id) references product (product_id)
);
-- them customer
insert into customer (customer_name,customer_age) values("Minh Quan",18);
insert into customer (customer_name,customer_age) values("Ngoc Oanh",20);
insert into customer (customer_name,customer_age) values("Hong Ha",50);
-- them order
insert into `order` (customer_id, order_date) values (1,'2006-03-21');
insert into `order` (customer_id, order_date) values (2,'2006-03-23');
insert into `order` (customer_id, order_date) values (1,'2006-03-16');
-- them product
insert into product (product_name,product_price) values("May Giat",3);
insert into product (product_name,product_price) values("Tu Lanh",5);
insert into product (product_name,product_price) values("Dieu Hoa",7);
insert into product (product_name,product_price) values("Quat",2);
insert into product (product_name,product_price) values("Bep Dien",1);
-- them order detail
insert into order_details values (1,1,3);
insert into order_details values (1,3,7);
insert into order_details values (1,4,2);
insert into order_details values (2,1,1);
insert into order_details values (3,1,8);
insert into order_details values (2,5,4);
insert into order_details values (2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order;
select order_id, order_date, order_price from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách;
select customer_name, product_name from customer
inner join `order` on customer.customer_id = `order`.customer_id
inner join order_details on `order`.order_id = order_details.order_id
inner join product on product.product_id = order_details.product_id;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào;
select customer_name, product_name from customer
left join `order` on customer.customer_id = `order`.customer_id
left join order_details on `order`.order_id = order_details.order_id
left join product on product.product_id = order_details.product_id
where `order`.customer_id is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice
select `order`.order_id, `order`.order_date, sum(order_details.order_quantity*product_price) as order_price from `order`
join order_details on `order`.order_id = order_details.order_id
join product on product.product_id = order_details.product_id
group by `order`.order_id;