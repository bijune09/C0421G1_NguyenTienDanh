CREATE DATABASE `student-management`;
CREATE TABLE `student` (
	`id` INT NOT NULL,
    `name` varchar(45) NULL,
    `age` INT NULL,
    `country` varchar(45) NULL,
    PRIMARY KEY(`id`)
);
INSERT INTO `student` VALUES (
1,
"Nguyễn Tiến Danh",
20,
"Đà Nẵng"
);
INSERT INTO `student` VALUES (
2,
"Trương Anh Quân",
21,
"Đà Nẵng"
);
DROP DATABASE `student-management`;