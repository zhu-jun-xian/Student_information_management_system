create database Student;
use Student;
drop table register;

CREATE TABLE register(
`id` varchar(100) NOT NULL,
`name` varchar(20),
`phoneNumber` int(20),
`password` varchar(20),
`password2` varchar(20),
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `register` values('3117004500','后裔','110120','12345601','12345601');
insert into `register` values('3117004501','鲁班','110119','12345602','12345602');
insert into `register` values('3117004502','公孙离','120119','12345603','12345603');
insert into `register` values('3117004503','张飞','120110','12345604','12345604');
insert into `register` values('3117004504','廉颇','119120','12345605','12345605');
insert into `register` values('3117004505','白起','119110','12345606','12345606');
insert into `register` values('3117004506','貂蝉','10086','12345607','12345607');
insert into `register` values('3117004507','王昭君','1008611','12345608','12345608');
insert into `register` values('3117004508','小乔','10000','12345609','12345609');
insert into `register` values('3117004509','大乔','1000001','12345610','12345610');


select * from register;