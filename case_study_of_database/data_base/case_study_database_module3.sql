create database if not exists case_study_database_module3;
use case_study_database_module3;

--  bang vi tri 
create table vi_tri(
ma_vi_tri int primary key,
ten_vi_tri varchar(45));

-- bang trinh do
create table trinh_do(
ma_trinh_do int primary key,
ten_trinh_do varchar(45));

-- bang bo phan
create table bo_phan(
ma_bo_phan int primary key,
ten_bo_phan varchar(45));

-- bang nhan vien
create table nhan_vien(
ma_nhan_vien int primary key AUTO_INCREMENT,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
luong double,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
ma_trinh_do int,
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
ma_bo_phan int,
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan));

-- bang loai khach
create table loai_khach(
ma_loai_khach int primary key,
ten_loai_khach varchar(45));

-- bang khach hang 
create table khach_hang(
ma_khach_hang int primary key AUTO_INCREMENT,
ma_loai_khach int,
foreign key(ma_loai_khach) references loai_khach(ma_loai_khach),
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh BIT(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45));

-- bang kieu thue 
create table kieu_thue(
ma_kieu_thue int primary key,
ten_kieu_thue varchar(45));

-- bang loai dich vu 
create table loai_dich_vu(
ma_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(45));

-- bang dich vu 
create table dich_vu(
ma_dich_vu int primary key,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
ma_kieu_thue int,
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue),
ma_loai_dich_vu int,
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu),
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_voi double,
so_trang int);

-- bang hop dong
create table hop_dong(
ma_hop_dong int primary key,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
ma_khach_hang int,
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
ma_dich_vu int,
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu));

-- bang dich vu di kem 
create table dich_vu_di_kem(
ma_dich_vu_di_kem int primary key,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45));

-- bang hop_dong_chi_tiet
create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key,
ma_hop_dong int,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
ma_dich_vu_di_kem int,
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem),
so_luong int);

-- them du lieu vao cac bang---------------------------------------------------

INSERT INTO vi_tri (ma_vi_tri, ten_vi_tri)
VALUE(1, 'Qu???n L??'),
	 (2, 'Nh??n Vi??n');
SELECT * FROM vi_tri;
     
INSERT INTO trinh_do (ma_trinh_do, ten_trinh_do)
VALUE(1, 'Trung C???p'),
     (2, 'Cao ?????ng'),
     (3, '?????i H???c'),
     (4, 'Sau ?????i H???c');
SELECT * FROM trinh_do;
     
INSERT INTO bo_phan (ma_bo_phan, ten_bo_phan)
VALUE(1, 'Sale-Marketing'),
	 (2, 'H??nh ch??nh'),
     (3, 'Ph???c v???'),
     (4, 'Qu???n l??');
SELECT * FROM bo_phan;
     
INSERT INTO nhan_vien
VALUE(1, 'Nguy???n V??n An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguy???n T???t Th??nh, ???? N???ng',	1, 3, 1),
     (2, 'L?? V??n B??nh', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Y??n B??i, ???? N???ng', 1, 2, 2),
     (3, 'H??? Th??? Y???n', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 ??i???n Bi??n Ph???, Gia Lai', 1, 3, 2),
     (4, 'V?? C??ng To???n', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???', 1, 4, 4),
     (5, 'Nguy???n B???nh Ph??t', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Y??n B??i, ???? N???ng', 2, 1, 1),
     (6, 'Kh??c Nguy???n An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguy???n T???t Th??nh, ???? N???ng', 2, 2, 3),
     (7, 'Nguy???n H???u H??', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguy???n Ch?? Thanh, Hu???', 2, 3, 2),
     (8, 'Nguy???n H?? ????ng', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 H??ng V????ng, H?? N???i', 2, 4, 4),
     (9, 'T??ng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 H??m Nghi, ???? N???ng', 2, 4, 4),
     (10, 'Nguy???n C??ng ?????o', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Ho?? Kh??nh, ?????ng Nai', 2, 3, 2);
 SELECT * FROM nhan_vien;
 
INSERT INTO loai_khach (ma_loai_khach, ten_loai_khach)
VALUE(1, 'Diamond'),
     (2, 'Platinium'),
     (3, 'Gold'),
     (4, 'Silver'),
     (5, 'Member');
SELECT * FROM loai_khach;
     
INSERT INTO khach_hang
VALUE(1, 5, 'Nguy???n Th??? H??o', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguy???n Ho??ng, ???? N???ng'),
     (2, 3, 'Ph???m Xu??n Di???u', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Th??i Phi??n, Qu???ng Tr???'),
     (3, 1, 'Tr????ng ????nh Ngh???', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 ??ng ??ch Khi??m, Vinh'),
     (4, 1, 'D????ng V??n Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 L?? L???i, ???? N???ng'),
     (5, 4, 'Ho??ng Tr???n Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 L?? Th??i T???, Gia Lai'),
     (6, 4, 'T??n N??? M???c Ch??u', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Y??n Th???, ???? N???ng'),
     (7, 1, 'Nguy???n M??? Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 L?? L???i, H??? Ch?? Minh'),
     (8, 3, 'Nguy???n Th??? H??o', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguy???n V??n Linh, Kon Tum'),
     (9, 1, 'Tr???n ?????i Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 L?? Th?????ng Ki???t, Qu???ng Ng??i'),
     (10, 2, 'Nguy???n T??m ?????c', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ng?? Quy???n, ???? N???ng');
SELECT * FROM khach_hang;
     
INSERT INTO kieu_thue (ma_kieu_thue, ten_kieu_thue)
VALUE(1, 'year'),
     (2, 'month'),
     (3, 'day'),
     (4, 'hour');
SELECT * FROM kieu_thue;
     
INSERT INTO loai_dich_vu (ma_loai_dich_vu, ten_loai_dich_vu)
VALUE(1, 'Villa'),
     (2, 'House'),
     (3, 'Room');
SELECT * FROM loai_dich_vu;
    
INSERT INTO dich_vu
VALUE(1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'C?? h??? b??i', 500, 4),
     (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'C?? th??m b???p n?????ng', null, 3),
     (3, 'Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'C?? tivi', null, null),
     (4, 'Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'C?? h??? b??i', 300, 3),
     (5, 'House Princess 02', 10000, 4000000, 5, 3, 2, 'normal', 'C?? th??m b???p n?????ng', null, 2),
     (6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'C?? tivi', null, null);
SELECT * FROM dich_vu;

INSERT INTO dich_vu_di_kem
VALUE(1, 'Karaoke', 10000, 'gi???', 'ti???n nghi, hi???n t???i'),
     (2, 'Thu?? xe m??y', 10000, 'chi???c', 'h???ng 1 xe'),
     (3, 'Thu?? xe ?????p', 20000, 'chi???c', 't???t'),
     (4, 'Buffet bu???i s??ng', 15000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
     (5, 'Buffet bu???i tr??a', 90000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
     (6, 'Buffet bu???i t???i', 16000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng');
SELECT * FROM dich_vu_di_kem;
     
INSERT INTO hop_dong
VALUE(1, '2020-12-08', '2020-12-08', 0, 3, 1, 3),
     (2, '2020-07-14', '2020-07-21', 200000, 7, 3, 1),
     (3, '2021-03-15', '2021-03-17', 50000, 3, 4, 2),
     (4, '2021-01-14', '2021-01-18', 100000, 7, 5, 5),
     (5, '2021-07-14', '2021-07-15', 0, 7, 2, 6),
     (6, '2021-06-01', '2021-06-03', 0, 7, 7, 6),
     (7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4),
     (8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1),
     (9, '2020-11-19', '2020-11-19', 0, 3, 4, 3),
     (10, '2021-04-12', '2021-04-14', 0, 10, 3, 5),
     (11, '2021-04-25', '2021-04-25', 0, 2, 2, 1),
     (12, '2021-05-25', '2021-05-27', 0, 7, 10, 1);
SELECT * FROM hop_dong;
     
INSERT INTO hop_dong_chi_tiet
VALUE(1,  2, 4, 5),
     (2, 2, 5, 8),
     (3, 2, 6, 15),
     (4, 3, 1, 1),
     (5, 3, 2, 11),
     (6, 1, 3, 1),
     (7, 1, 2, 2),
     (8, 12, 2, 2);
SELECT * FROM hop_dong_chi_tiet;

-- cau 1.Th??m m???i th??ng tin cho t???t c??? c??c b???ng c?? trong CSDL ????? c?? th??? tho??? m??n c??c y??u c???u b??n d?????i.

-- cau 2.Hi???n th??? th??ng tin c???a t???t c??? nh??n vi??n c?? trong h??? th???ng c?? t??n b???t ?????u l?? m???t trong c??c k?? t??? ???H???, ???T??? ho???c ???K??? v?? c?? t???i ??a 15 k?? t???.
 -- select*from nhan_vien where ho_ten like '%h' or ho_ten like '%t' or ho_ten like '%k' and length(ho_ten) < 16;
 
 select*from nhan_vien where ho_ten regexp '^[HTK]' and char_length(ho_ten)<=15;
 
 select*from nhan_vien where ho_ten like 'h%' or ho_ten like 't%' or ho_ten like 'k%' and char_length(ho_ten)<=15;
-- chu thich: ^[HTK]
 -- cau 3.Hi???n th??? th??ng tin c???a t???t c??? kh??ch h??ng c?? ????? tu???i t??? 18 ?????n 50 tu???i v?? c?? ?????a ch??? ??? ??????? N???ng??? ho???c ???Qu???ng Tr??????.
select*from khach_hang where (year(now())-year(ngay_sinh) between 18 and 50) and (dia_chi like '%???? n??ng' or dia_chi like '%qu???ng tri');

-- cau 4.?????m xem t????ng ???ng v???i m???i kh??ch h??ng ???? t???ng ?????t ph??ng bao nhi??u l???n. K???t qu??? hi???n th??? ???????c s???p x???p t??ng d???n theo s??? l???n ?????t ph??ng c???a kh??ch h??ng. Ch??? ?????m nh???ng kh??ch h??ng n??o c?? T??n lo???i kh??ch h??ng l?? ???Diamond???.

select khach_hang.ma_khach_hang, ho_ten, count(khach_hang.ma_khach_hang) as so_lan_dat_phong 
from khach_hang
inner join hop_dong
on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where khach_hang.ma_loai_khach = 1
group by hop_dong.ma_khach_hang
order by so_lan_dat_phong;

-- cau 5.	Hi???n th??? ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tong_tien (V???i t???ng ti???n ???????c t??nh theo c??ng th???c nh?? sau: Chi Ph?? Thu?? + S??? L?????ng * Gi??, v???i S??? L?????ng v?? Gi?? l?? t??? b???ng dich_vu_di_kem, hop_dong_chi_tiet) cho t???t c??? c??c kh??ch h??ng ???? t???ng ?????t ph??ng.
-- (nh???ng kh??ch h??ng n??o ch??a t???ng ?????t ph??ng c??ng ph???i hi???n th??? ra).

select khach_hang.ma_khach_hang, ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
ifnull(dich_vu.chi_phi_thue,0) + ifnull(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia,0) as tong_tien
from khach_hang
left join loai_khach
on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong
on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu
on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet
on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem
on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where khach_hang.ma_khach_hang is not null
group by hop_dong.ma_hop_dong
order by ma_khach_hang, hop_dong.ma_hop_dong desc;

-- cau 6. Hi???n th??? ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- c???a t???t c??? c??c lo???i d???ch v??? ch??a t???ng ???????c kh??ch h??ng th???c hi???n ?????t t??? qu?? 1 c???a n??m 2021 (Qu?? 1 l?? th??ng 1, 2, 3).

select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
left join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where dich_vu.ma_dich_vu not in (select ma_dich_vu from hop_dong where ngay_lam_hop_dong between '2021-01-01'and '2021-03-31')
group by hop_dong.ma_dich_vu;

-- c??u 7. Hi???n th??? th??ng tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- c???a t???t c??? c??c lo???i d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2020 nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2021.

select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
left join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
left join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where dich_vu.ma_dich_vu 
in (select ma_dich_vu from hop_dong where ngay_lam_hop_dong between '2020-01-01'and '2020-12-31')
and dich_vu.ma_dich_vu not in (select ma_dich_vu from hop_dong where ngay_lam_hop_dong between '2021-01-01'and '2021-12-31')
group by hop_dong.ma_dich_vu;


-- cau 8. Hi???n th??? th??ng tin ho_ten kh??ch h??ng c?? trong h??? th???ng, v???i y??u c???u ho_ten kh??ng tr??ng nhau.
-- //cach 1:
select ho_ten 
from khach_hang
group by ho_ten;
-- //cach 2:
select distinct(ho_ten) from khach_hang;
-- //cach 3:
select ho_ten
	from khach_hang
union
select ho_ten
	from khach_hang;
    
    
-- cau 9. Th???c hi???n th???ng k?? doanh thu theo th??ng,
-- ngh??a l?? t????ng ???ng v???i m???i th??ng trong n??m 2021 th?? s??? c?? bao nhi??u kh??ch h??ng th???c hi???n ?????t ph??ng.
select month(ngay_lam_hop_dong) t, count(khach_hang.ma_khach_hang) as so_khach_dat_phong from khach_hang
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where year(ngay_lam_hop_dong) = 2021
group by t
order by t;

-- //cach 2:
SELECT
    tmp.thang,
    co.so_lan_khach_dat
FROM
    (
        SELECT
            1 AS thang
        UNION
        SELECT
            2 AS thang
        UNION
        SELECT
            3 AS thang
        UNION
        SELECT
            4 AS thang
        UNION
        SELECT
            5 AS thang
        UNION
        SELECT
            6 AS thang
        UNION
        SELECT
            7 AS thang
        UNION
        SELECT
            8 AS thang
        UNION
        SELECT
            9 AS thang
        UNION
        SELECT
            10 AS thang
        UNION
        SELECT
            11 AS thang
        UNION
        SELECT
            12 AS thang
    ) AS tmp
    LEFT JOIN (
        SELECT
            month(ngay_lam_hop_dong) AS thang,
            count(ma_khach_hang) AS so_lan_khach_dat
        FROM
            hop_dong
        WHERE
            YEAR(ngay_lam_hop_dong) = '2021'
        GROUP BY
            thang
    ) AS co USING (thang);

-- cau 10. Hi???n th??? th??ng tin t????ng ???ng v???i t???ng h???p ?????ng th?? ???? s??? d???ng bao nhi??u d???ch v??? ??i k??m.
-- K???t qu??? hi???n th??? bao g???m ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem).

select hop_dong.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong;

-- cau 11. Hi???n th??? th??ng tin c??c d???ch v??? ??i k??m ???? ???????c s??? d???ng b???i nh???ng kh??ch h??ng c?? ten_loai_khach l?? ???Diamond??? v?? c?? dia_chi ??? ???Vinh??? ho???c ???Qu???ng Ng??i???.
select dich_vu_di_kem.ma_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai, ma_loai_khach
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where dia_chi like '%Vinh%' or dia_chi like '%Qu???ng Ng??i' and ma_loai_khach = 1;

-- cau 12. Hi???n th??? th??ng tin ma_hop_dong, ho_ten (nh??n vi??n), ho_ten (kh??ch h??ng), so_dien_thoai (kh??ch h??ng), ten_dich_vu, so_luong_dich_vu_di_kem 
-- (???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem), tien_dat_coc c???a t???t c??? c??c d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t v??o 3 th??ng cu???i n??m 2020 
-- nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t v??o 6 th??ng ?????u n??m 2021.

select hop_dong.ma_hop_dong,nhan_vien.ho_ten as 'nh??n vi??n',khach_hang.ho_ten as 'kh??ch h??ng',khach_hang.so_dien_thoai,dich_vu.ten_dich_vu,tien_dat_coc,ngay_lam_hop_dong, sum(so_luong) as 's??? l?????ng d???ch v??? ??i k??m' 
 from dich_vu
 join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
 join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
 join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
 left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
 left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
 where (ngay_lam_hop_dong between '2020-10-01' and '2020-12-31') and ngay_lam_hop_dong not in (select ngay_lam_hop_dong
 where ngay_lam_hop_dong between '2021-01-01' and '2021-06-30')
 group by ma_hop_dong;

-- c??u 13: 
/*Hi???n th??? th??ng tin c??c D???ch v??? ??i k??m ???????c s??? d???ng nhi???u nh???t b???i c??c Kh??ch h??ng ???? ?????t ph??ng. (L??u ?? l?? c?? th??? c?? nhi???u d???ch v??? c?? s??? l???n s??? d???ng nhi???u nh?? nhau)*/
select dich_vu_di_kem.ten_dich_vu_di_kem,sum(so_luong) as so_lan_dat
from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_dat >= all (select sum(so_luong) from hop_dong_chi_tiet group by ma_dich_vu_di_kem);

-- c??u 14: 
/*Hi???n th??? th??ng tin t???t c??? c??c D???ch v??? ??i k??m ch??? m???i ???????c s??? d???ng m???t l???n duy nh???t. Th??ng tin hi???n th??? bao g???m ma_hop_dong, ten_loai_dich_vu,
ten_dich_vu_di_kem, so_lan_su_dung (???????c t??nh d???a tr??n vi???c count c??c ma_dich_vu_di_kem)*/
-- table: hop_dong/dich_vu/loai_dich_vu/hop_dong_chi_tiet/dich_vu_di_kem
select hop_dong.ma_hop_dong,ten_loai_dich_vu,ten_dich_vu_di_kem, count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong
join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung = 1;

-- c??u 15: 
/*Hi???n thi th??ng tin c???a t???t c??? nh??n vi??n bao g???m ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai,
 dia_chi m???i ch??? l???p ???????c t???i ??a 3 h???p ?????ng t??? n??m 2020 ?????n 2021*/
select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten,ten_trinh_do,ten_bo_phan,so_dien_thoai,dia_chi
from nhan_vien
join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where year(ngay_lam_hop_dong) between 2020 and 2021
group by ma_nhan_vien
having count(hop_dong.ma_hop_dong) <= 3;

-- c??u 16:
/*X??a nh???ng Nh??n vi??n ch??a t???ng l???p ???????c h???p ?????ng n??o t??? n??m 2019 ?????n n??m 2021*/
delete from nhan_vien
where ho_ten not in (
select * from(
select nhan_vien.ho_ten from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where year(ngay_lam_hop_dong) between 2019 and 2021
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_hop_dong) > 0) as test);

-- c??u 17: 
/*C???p nh???t th??ng tin nh???ng kh??ch h??ng c?? ten_loai_khach t??? Platinum l??n Diamond, ch??? c???p nh???t nh???ng kh??ch h??ng ???? t???ng
?????t ph??ng v???i T???ng Ti???n thanh to??n trong n??m 2021 l?? l???n h??n 10.000.000 VN??*/
update khach_hang 
set ma_loai_khach = 1 
where ho_ten in ( 
select * from(
select ho_ten from khach_hang 
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(ngay_lam_hop_dong) = 2021 and ten_loai_khach = 'platinum'
group by khach_hang.ma_khach_hang
having sum(chi_phi_thue) + sum(dich_vu_di_kem.gia*hop_dong_chi_tiet.so_luong) >= 10000000
) as test);


 