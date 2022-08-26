create database if not exists thi_thuc_hanh;
use thi_thuc_hanh;
set foreign_key_checks = 0;
set sql_safe_updates = 0;
create table if not exists sach(
ma_sach int primary key auto_increment,
ten_sach varchar(50),
tac_gia varchar(50),
mo_ta varchar(50),
so_luong int);

create table if not exists hoc_sinh(
ma_hoc_sinh int primary key auto_increment,
ho_ten varchar(50),
lop varchar(50));

create table if not exists the_muon_sach(
ma_muon_sach int primary key auto_increment,
ma_sach int,
foreign key(ma_sach) references sach(ma_sach),
ma_hoc_sinh int,
foreign key(ma_hoc_sinh) references hoc_sinh(ma_hoc_sinh),
trang_thai boolean,
ngay_muon date not null,
ngay_tra date not null)
select*from sach;

insert into sach(ma_sach,ten_sach,tac_gia,so_luong,mo_ta) values ("1", "SỐ ĐỎ", "VŨ TRỌNG PHỤNG", "10", "NHÂN VẬT CHÍNH LÀ SƠN TÓC ĐỎ");
insert into sach(ma_sach,ten_sach,tac_gia,so_luong,mo_ta) values ("2", "LÃO HẠC", "NAM CAO", "12", "LÃO HẠC VÀ CẬU VÀNG");
drop database thi_thuc_hanh;
