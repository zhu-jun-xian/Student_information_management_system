create database Student;
use Student;

DROP TABLE IF EXISTS `StudentInformationTable`;
CREATE TABLE `StudentInformationTable` (
  `stuNum` int(20) NOT NULL AUTO_INCREMENT,
  `stuID` varchar(30) NOT NULL UNIQUE, 
  `stuName` varchar(30) ,
  `stuBirth` varchar(30) ,
  `stuSex` varchar(10) ,
  `stuTel` varchar(30) ,
  `stuClass` varchar(10) ,
  `stuDep` varchar(30) ,
  `stuAddTimed` varchar(30),
  `stuImgUrl` varchar(100),
  PRIMARY KEY (`stuNum`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into `StudentInformationTable` values('1','3117004500','鲁班','19980601','男','13700030303','IBM5班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('2','3117004501','鲁w班','19980602','男','13111343211','IBM5班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('3','3117004502','公孙离','19980603','女','11243432123','IBM5班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('4','3117004503','张飞','19980602','男','112432333323','IBM5班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('5','3117004504','廉颇','19980602','男','112432342345','IBM5班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('6','3117004505','白起','19980602','男','11243237777','IBM5班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('7','3117004506','貂蝉','19980602','女','11243237532','IBM5班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('8','3117004507','王昭君','19980602','女','11243183823','IBM5班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('9','3117004508','小乔','19980602','女','11243234212','IBM5班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('10','3117004509','大乔','19980602','女','11243221923','IBM5班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('11','3117004700','鲁班1','19980601','男','11243335223','IBM5班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('12','3117004511','鲁班2','19980602','男','11233324123','IBM6班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('13','3117004512','公孙离3','19980603','女','1234334123','IBM6班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('14','3117004513','张飞2','19980602','男','11209874123','IBM6班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('15','3117004514','廉颇2','19980602','男','11243234123','IBM6班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('16','3117004515','白起2','19980602','男','11245959123','IBM5班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('17','3117004516','貂蝉2','19980602','女','11242020123','IBM1班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('18','3117004517','王昭君2','19980602','女','11333334123','IBM1班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('19','3117004518','小乔2','19980602','女','11241919123','IBM1班','外国语学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('20','3117004519','大乔2','19980602','女','11242222123','IBM1班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('21','3117004520','鲁班3','19980601','男','11240003123','IBM2班','外国语学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('22','3117004521','鲁班5','19980602','男','11249930123','IBM2班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('23','3117004522','公孙离6','19980603','女','11399334123','IBM2班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('24','3117004523','张飞22','19980602','男','11200824123','IBM2班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('25','3117004524','廉颇24','19980602','男','11299994123','IBM2班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('26','3117004525','白起45','19980602','男','11218184123','IBM3班','外国语学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('27','3117004526','貂蝉fg','19980602','女','11200984123','IBM3班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('28','3117004527','王昭34君','19980602','女','14884234123','IBM3班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('29','3117004528','小乔43','19980602','女','113637334123','IBM3班','外国语学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('30','3117004529','大乔34','19980602','女','11999934123','IBM3班','外国语学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('31','3117004530','鲁班e','19980601','男','11211534123','IBM4班','土木工程学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('32','3117004531','鲁r班','19980602','男','11255554123','IBM4班','土木工程学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('33','3117004532','公孙离5','19980603','女','29743234123','IBM6班','外国语学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('34','3117004533','张6飞','19980602','男','1222234123','IBM6班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('35','3117004534','廉5颇','19980602','男','11000034123','IBM6班','土木工程学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('36','3117004535','白起g','19980602','男','11243333323','IBM6班','外国语学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('37','3117004536','貂蝉s','19980602','女','11243292823','IBM6班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('38','3117004537','王昭c君','19980602','女','11222224123','IBM6班','艺术设计学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('39','3117004538','小乔d','19980602','女','11243997623','IBM7班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('40','3117004539','大乔z','19980602','女','11243268623','IBM7班','艺术设计学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('41','3117004540','鲁x班','19980601','男','11243197623','IBM7班','土木工程学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('42','3117004541','鲁v班','19980602','男','11243629023','IBM7班','艺术设计学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('43','3117004542','公w孙离','19980603','女','11232164123','IBM7班','智能制造学部','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('44','3117004543','张w飞','19980602','男','112431234123','IBM7班','土木工程学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('45','3117004544','廉颇g','19980602','男','11243275123','IBM7班','艺术设计学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('46','3117004545','白起i','19980602','男','11243232123','IBM1班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('47','3117004546','貂蝉k','19980602','女','11243234323','IBM1班','艺术设计学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('48','3117004547','王昭k君','19980602','女','11243224123','IBM1班','经济管理学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('49','3117004548','小乔k','19980602','女','11243234125','IBM1班','艺术设计学院','2020-11-18','https:www.baidu.com');
insert into `StudentInformationTable` values('50','3117004549','大乔7','19980602','女','11243234127','IBM1班','土木工程学院','2020-11-18','https:www.baidu.com');




select * from StudentInformationTable;

select count(stuSex) from StudentInformationTable;

use student;


CREATE TABLE usertable(
`ID` varchar(100) NOT NULL UNIQUE,
`Name` varchar(35),
`Tel` varchar(30),
`Password` varchar(20),
PRIMARY KEY (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into `usertable` values('3117004503','张飞','120110','12345604');
insert into `usertable` values('3117004504','廉颇','119120','12345605');
insert into `usertable` values('3117004505','白起','119110','12345606');
insert into `usertable` values('3117004506','貂蝉','10086','12345607');
insert into `usertable` values('3117004507','王昭君','1008611','12345608');
insert into `usertable` values('3117004508','小乔','10000','12345609');
insert into `usertable` values('3117004509','大乔','1000001','12345610');


select * from usertable;



SELECT Count(stuSex)'女' FROM  studentinformationtable where stuSex='女' GROUP BY stuSex ;

SELECT Count(stuSex)'男' FROM  studentinformationtable where stuSex='男' GROUP BY stuSex ;

SELECT Count(stuClass)'IBM6班' FROM  studentinformationtable where stuClass='IBM1班' GROUP BY stuClass ;

SELECT Count(stuDep)'经济管理学院' FROM  studentinformationtable where stuDep='经济管理学院' GROUP BY stuDep ;

select distinct stuClass from studentinformationtable 

select distinct stuSex from studentinformationtable

select stuSex sex,Count(stuSex) countSex from studentinformationtable where stuSex in(select distinct stuSex from studentinformationtable) group by stuSex

select distinct stuDep from studentinformationtable 


use student;

select * from studentinformationtable 
  WHERE stuID like concat('%%') 
       and stuName like concat('%%') 
      and stuBirth like concat('%%')
      and stuSex like concat('%女%')
      and stuTel like concat('%%')
      and stuClass like concat('%%')
      and stuDep like concat('%%')
      
      
	select * from studentinformationtable 
  WHERE stuID like concat('%%') studentinformationtable
       or stuName like concat('%%') 
      or stuBirth like concat('%%')
      or stuSex like concat('%女%')
      or stuTel like concat('%%')
      or stuClass like concat('%%')
      or stuDep like concat('%%')