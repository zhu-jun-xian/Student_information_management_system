create database SIM;

use SIM;

DROP TABLE IF EXISTS `studentInformation`;
CREATE TABLE `studentInformation` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `studentNumber` varchar(30) DEFAULT NULL, 
  `name` varchar(30) DEFAULT NULL,
  `birth` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(30) DEFAULT NULL,
  `class` varchar(30) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO studentInformation VALUES ('1', '3117004544', '林某某','19980628','男','110','5','电信信安');
INSERT INTO studentInformation VALUES ('2', '3117004544', '林某某','19980628','男','110','5','电信信安');
INSERT INTO studentInformation VALUES ('3', '3117004544', '林某某','19980628','男','110','5','电信信安');
INSERT INTO studentInformation VALUES ('4', '3117004544', '林某某','19980628','男','110','5','电信信安');
INSERT INTO studentInformation VALUES ('5', '3117004544', '林某某','19980628','男','110','5','电信信安');

select * from studentInformation;