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
--
create table Permision(
id int(11) primary key,
`name` varchar(50)
);

create table user_permision (
permision_id int(11),
user_id int(11)
);

insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');

insert into Permision(id, name) values(4, 'view');