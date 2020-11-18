create database Student;
use Student;
drop table login;

CREATE TABLE login(
`id` varchar(100) NOT NULL,
`password` varchar(20),
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `login` values('3117004500','12345601');
insert into `login` values('3117004501','12345602');
insert into `login` values('3117004502','12345603');
insert into `login` values('3117004503','12345604');
insert into `login` values('3117004504','12345605');
insert into `login` values('3117004505','12345606');
insert into `login` values('3117004506','12345607');
insert into `login` values('3117004507','12345608');
insert into `login` values('3117004508','12345609');
insert into `login` values('3117004509','12345610');

select * from login;