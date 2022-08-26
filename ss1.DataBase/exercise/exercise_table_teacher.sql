create database if not exists student_management;
use student_management;
create table `student_management`.class (
id int,
name varchar(50));

select*from student_management.class;
-- drop database managemnt;
insert into student_management.class(id, name) value(1, "A1121I1");

create table teacher(
id int,
name varchar(50),
age varchar(50),
country varchar(50));

insert into student_management.teacher(id, name, age, country) value (1, "Thảo","18","Viet_Nam");
insert into student_management.teacher(id, name, age, country) value (2, "Van","19","laos");
insert into student_management.teacher(id, name, age, country) value (2, "Van","19","laos");

select*from student_management.teacher;


