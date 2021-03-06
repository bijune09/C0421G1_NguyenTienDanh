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
-- Hi???n th??? c??c th??ng tin  g???m oID, oDate, oPrice c???a t???t c??? c??c h??a ????n trong b???ng Order;
select order_id, order_date, order_price from `order`;
-- Hi???n th??? danh s??ch c??c kh??ch h??ng ???? mua h??ng, v?? danh s??ch s???n ph???m ???????c mua b???i c??c kh??ch;
select customer_name, product_name from customer
join `order` on customer.customer_id = `order`.customer_id
join order_details on `order`.order_id = order_details.order_id
join product on product.product_id = order_details.product_id;
-- Hi???n th??? t??n nh???ng kh??ch h??ng kh??ng mua b???t k??? m???t s???n ph???m n??o;
select customer_name,product_name from customer
left join `order` on customer.customer_id = `order`.customer_id
left join order_details on `order`.order_id = order_details.order_id
left join product on product.product_id = order_details.product_id
where `order`.customer_id is null;
-- Hi???n th??? m?? h??a ????n, ng??y b??n v?? gi?? ti???n c???a t???ng h??a ????n (gi?? m???t h??a ????n ???????c t??nh b???ng t???ng gi?? b??n c???a t???ng lo???i m???t h??ng xu???t hi???n trong h??a ????n. 
-- Gi?? b??n c???a t???ng lo???i ???????c t??nh = odQTY*pPrice
select `order`.order_id, `order`.order_date, sum(order_details.order_quantity*product_price) as order_price from `order`
join order_details on `order`.order_id = order_details.order_id
join product on product.product_id = order_details.product_id
group by order_details.order_id;