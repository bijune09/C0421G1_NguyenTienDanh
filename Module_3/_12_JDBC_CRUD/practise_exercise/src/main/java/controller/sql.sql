drop database if exists demo;
create database demo;
use demo;

create table users (
id int(3) not null auto_increment primary key,
`name` varchar(120) not null,
email varchar(220) not null,
country varchar(12)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
-- country-- 
select id,`name`,email,country
from users
where country = 'kenia';
-- name--
select id,`name`,email,country
from users
order by `name`;