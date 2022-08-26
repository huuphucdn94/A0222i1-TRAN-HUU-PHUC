create database `demo1`;
use `demo1`;
create table `users`(
id int(3) not null auto_increment,
`name` varchar(120) not null,
email varchar(220) not null,
 country varchar(120),
 PRIMARY KEY (id));
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
