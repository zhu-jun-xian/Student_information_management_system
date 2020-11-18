create database Student;
use Student;

DROP TABLE IF EXISTS `studentInformation`;
CREATE TABLE `studentInformation` (
  `stuNum` int(20) NOT NULL,
  `stuID` varchar(30) NOT NULL, 
  `stuName` varchar(30) ,
  `stuBirth` varchar(10) ,
  `stuSex` varchar(10) ,
  `stuTel` varchar(30) ,
  `stuClass` varchar(10) ,
  `stuDep` varchar(30) ,
  PRIMARY KEY (`stuID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into `studentInformation` values('1','3117004500','鲁班','19980601','男','110120','5','电信');
insert into `studentInformation` values('2','3117004501','鲁班','19980602','男','110119','5','信安');
insert into `studentInformation` values('3','3117004502','公孙离','19980603','女','120119','5','电信');
insert into `studentInformation` values('4','3117004503','张飞','19980602','男','120110','5','信安');
insert into `studentInformation` values('5','3117004504','廉颇','19980602','男','119120','5','电信');
insert into `studentInformation` values('6','3117004505','白起','19980602','男','119110','5','信安');
insert into `studentInformation` values('7','3117004506','貂蝉','19980602','女','10086','5','电信');
insert into `studentInformation` values('8','3117004507','王昭君','19980602','女','1008611','5','信安');
insert into `studentInformation` values('9','3117004508','小乔','19980602','女','10000','5','电信');
insert into `studentInformation` values('10','3117004509','大乔','19980602','女','1000001','5','信安');

select * from studentInformation;

select count(gender) from studentInformation;