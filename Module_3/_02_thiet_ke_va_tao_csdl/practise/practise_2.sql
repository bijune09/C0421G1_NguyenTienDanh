create database quan_li_diem_thi;
use quan_li_diem_thi;
create table `student`(
	id_student varchar(20) primary key,
    name_student varchar(50),
    date_of_birth datetime,
    class varchar(20),
    gender varchar(20)
);
create table `subject`(
	id_subject varchar(20) primary key,
    name_subject varchar(50)
);
create table `transcript`(
	id_student varchar(20),
    id_subject varchar(20),
    test_score int,
    test_day datetime,
    primary key(id_student, id_subject),
    foreign key (id_student) references `student`(id_student),
    foreign key (id_subject) references `subject`(id_subject)
);
create table `teacher`(
	id_teacher varchar(20) primary key,
    name_teacher varchar(50),
    phone_numeber varchar(10)
);
alter table `subject` add id_teacher varchar(20);
alter table `subject` add constraint FK_id_teacher foreign key (id_teacher) references `teacher`(id_teacher);
