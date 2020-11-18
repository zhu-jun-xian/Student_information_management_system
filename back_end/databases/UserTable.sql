create database Student;
use Student;
drop table register;

CREATE TABLE UserTable(
`ID` varchar(100) NOT NULL,
`Name` varchar(20),
`Tel` int(20),
`Password` varchar(20),
PRIMARY KEY (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `UserTable` values('3117004500','后裔','110120','12345601');
insert into `UserTable` values('3117004501','鲁班','110119','12345602');
insert into `UserTable` values('3117004502','公孙离','120119','12345603');
insert into `UserTable` values('3117004503','张飞','120110','12345604');
insert into `UserTable` values('3117004504','廉颇','119120','12345605');
insert into `UserTable` values('3117004505','白起','119110','12345606');
insert into `UserTable` values('3117004506','貂蝉','10086','12345607');
insert into `UserTable` values('3117004507','王昭君','1008611','12345608');
insert into `UserTable` values('3117004508','小乔','10000','12345609');
insert into `UserTable` values('3117004509','大乔','1000001','12345610');


select * from UserTable;