create database bai_tap;
create table `class` (
	id INT,
    `name` varchar(50)
);
INSERT INTO `class` VALUES (
	1,
    "Ada"
);
INSERT INTO `class` VALUES (
	2,
    "Linus"
);
create table `teacher` (
	id INT,
    `name` varchar(50),
    age INT,
    `country` varchar(50)
);
insert into `teacher` values(
	1,
    "chien.tran",
    24,
    "Quảng Bình"
);
insert into `teacher` values(
	2,
    "trung.doan",
    34,
    "Đà Nẵng"
);