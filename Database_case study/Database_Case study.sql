create database if not exists database_case_study;
use database_case_study;
-- bảng vị trí

create table vi_tri(
ma_vi_tri int primary key,
ten_vi_tri varchar(45));

-- bảng trình độ 
create table trinh_do(
ma_trinh_do int primary key,
ten_trinh_do varchar(45));

-- bảng bộ phận 
create table bo_phan(
ma_bo_phan int primary key,
ten_bo_phan varchar(45));

-- bảng nhân viên 
create table bang_nhan_vien(
ma_nhan_vien int primary key,
ho_ten varchar(45)
);