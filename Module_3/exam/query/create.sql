DROP database if exists exam;
create database exam;
use exam;
create table category_product
( 
category_id int auto_increment primary key,
category_name varchar(50)
);

create table product
(
id_product int auto_increment primary key,
product_name varchar(20) not null,
product_price double not null check( product_price > 10000000) ,
quantity int not null check (quantity > 0),
color varchar(50),
category_id int,
foreign key (category_id) references category_product(category_id) on delete cascade on update cascade
);

insert into category_product (category_name)
values ('Phone'),('Tivi'),('Tủ lạnh'),('Máy giặt');

insert into product(product_name,product_price,quantity,color,category_id)
values ('Iphone',200000000,12,'black',1);