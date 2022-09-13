create database thi_thu_thuc_hanh;
use thi_thu_thuc_hanh;

-- create table category(
-- id_category int primary key,
-- category varchar(50));

create table product(
id_product int not null auto_increment primary key,
`name` varchar(50),
price long,
quantity int,
color varchar(50),
category varchar(50),
-- foreign key(id_category) references category(id_category));


insert into product (`name`,price, quantity,color,category) values ('iphone11 pro','1000','2','black','1');
insert into product (`name`,price, quantity,color,category) values ('iphone xs max','700','3','black','2');
insert into product (`name`,price, quantity,color,category) values ('iphone 12','1200','5','blue','3');


select * from product;
drop database thi_thu_thuc_hanh;