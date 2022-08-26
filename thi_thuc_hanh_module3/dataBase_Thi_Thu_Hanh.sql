create database if not exists thi_thuc_hanh;
use thi_thuc_hanh;
set foreign_key_checks = 0;
set sql_safe_updates = 0;

create table category (
id_san_pham int primary key auto_increment,
ten_san_pham varchar(50),
gia_san_pham int,
so_luong_san_pham int,
mau_sac_san_pham varchar(50),
mo_ta_san_pham varchar(50),
danh_muc varchar(50));
select*from category;
insert into category(id_san_pham, ten_san_pham, gia_san_pham, so_luong_san_pham, mau_sac_san_pham, mo_ta_san_pham, danh_muc) values 
("1", "iPhone 11", "799", "12", "Purple", "hang chinh hang", "con hang");
insert into category(id_san_pham, ten_san_pham, gia_san_pham, so_luong_san_pham, mau_sac_san_pham, mo_ta_san_pham, danh_muc) values 
("2", "iPhone 11", "799", "12", "Purple", "hang chinh hang", "con hang");
