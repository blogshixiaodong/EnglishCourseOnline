/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.0.24-community-nt : Database - englishcourseonline_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`englishcourseonline_test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `englishcourseonline_test`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `COURSEID` int(11) NOT NULL,
  `COURSENAME` varchar(255) default NULL,
  `INFO` varchar(255) default NULL,
  `TYPES` varchar(255) default NULL,
  `PRICE` float default NULL,
  `IMGURL` varchar(255) default NULL,
  PRIMARY KEY  (`COURSEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `courserecord` */

DROP TABLE IF EXISTS `courserecord`;

CREATE TABLE `courserecord` (
  `COURSERECORDID` int(11) NOT NULL,
  `STARTTIME` datetime default NULL,
  `ENDTIME` datetime default NULL,
  `CLOSETIME` datetime default NULL,
  `SIGNCOUNT` int(11) default NULL,
  `COURSEID` int(11) default NULL,
  PRIMARY KEY  (`COURSERECORDID`),
  KEY `FKr6dyx456wy0jnbied49p7ol94` (`COURSEID`),
  CONSTRAINT `FKr6dyx456wy0jnbied49p7ol94` FOREIGN KEY (`COURSEID`) REFERENCES `course` (`COURSEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `engclass` */

DROP TABLE IF EXISTS `engclass`;

CREATE TABLE `engclass` (
  `ENGCLASSID` int(11) NOT NULL,
  `ENGCLASSNAME` varchar(255) default NULL,
  `USERCOUNT` int(11) default NULL,
  `CLASSROOM` varchar(255) default NULL,
  `DAY` int(11) default NULL,
  `ATTENDTIME` int(11) default NULL,
  `COURSERECORDID` int(11) default NULL,
  `TEACHERID` int(11) default NULL,
  PRIMARY KEY  (`ENGCLASSID`),
  KEY `FKt6j10stw0uxo647xhn7xmobeg` (`COURSERECORDID`),
  KEY `FK84tq6fha9lbdxrhvo1ufub783` (`TEACHERID`),
  CONSTRAINT `FK84tq6fha9lbdxrhvo1ufub783` FOREIGN KEY (`TEACHERID`) REFERENCES `teacher` (`TEACHERID`),
  CONSTRAINT `FKt6j10stw0uxo647xhn7xmobeg` FOREIGN KEY (`COURSERECORDID`) REFERENCES `courserecord` (`COURSERECORDID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `TEACHERID` int(11) NOT NULL,
  `TEACHERNAME` varchar(255) default NULL,
  `IDCARD` varchar(255) default NULL,
  `SEX` varchar(255) default NULL,
  `AGE` int(11) default NULL,
  `PHONE` varchar(255) default NULL,
  `ADDRESS` varchar(255) default NULL,
  `IMGURL` varchar(255) default NULL,
  PRIMARY KEY  (`TEACHERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `teacheraccount` */

DROP TABLE IF EXISTS `teacheraccount`;

CREATE TABLE `teacheraccount` (
  `ID` int(11) NOT NULL,
  `PASSWORD` varchar(255) default NULL,
  `teacherid` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `UK_jhuf3jecu8v3r3xig56f9a7by` (`teacherid`),
  CONSTRAINT `FKdl2g80lw52quimq7duh56dlx5` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`TEACHERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `teacherbackinfo` */

DROP TABLE IF EXISTS `teacherbackinfo`;

CREATE TABLE `teacherbackinfo` (
  `TEACHERBACKINFOID` int(11) NOT NULL,
  `BACKTIME` datetime default NULL,
  `BACKINFO` varchar(255) default NULL,
  `USERID` int(11) default NULL,
  `ENGCLASSID` int(11) default NULL,
  `TEACHERID` int(11) default NULL,
  PRIMARY KEY  (`TEACHERBACKINFOID`),
  KEY `FKisgr3ucg3kg18iqhspm92s5gb` (`USERID`),
  KEY `FKnh3vq5yoeby0kbld4wl37shn` (`ENGCLASSID`),
  KEY `FKeeu40ugww91i3vl938n5h1xtw` (`TEACHERID`),
  CONSTRAINT `FKeeu40ugww91i3vl938n5h1xtw` FOREIGN KEY (`TEACHERID`) REFERENCES `teacher` (`TEACHERID`),
  CONSTRAINT `FKisgr3ucg3kg18iqhspm92s5gb` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`),
  CONSTRAINT `FKnh3vq5yoeby0kbld4wl37shn` FOREIGN KEY (`ENGCLASSID`) REFERENCES `engclass` (`ENGCLASSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `timesheet` */

DROP TABLE IF EXISTS `timesheet`;

CREATE TABLE `timesheet` (
  `TIMESHEETID` int(11) NOT NULL,
  `RECORDTIME` datetime default NULL,
  `SHEETINFO` varchar(255) default NULL,
  `USERID` int(11) default NULL,
  `ENGCLASSID` int(11) default NULL,
  PRIMARY KEY  (`TIMESHEETID`),
  KEY `FKjs9x5mujefwn5yqg2319dimrm` (`USERID`),
  KEY `FKbck41kmt0u1871bj4e138jfv2` (`ENGCLASSID`),
  CONSTRAINT `FKbck41kmt0u1871bj4e138jfv2` FOREIGN KEY (`ENGCLASSID`) REFERENCES `engclass` (`ENGCLASSID`),
  CONSTRAINT `FKjs9x5mujefwn5yqg2319dimrm` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `USERID` int(11) NOT NULL,
  `USERNAME` varchar(255) default NULL,
  `IDCARD` varchar(255) default NULL,
  `SEX` varchar(255) default NULL,
  `AGE` varchar(255) default NULL,
  `PHONE` varchar(255) default NULL,
  `ADDRESS` varchar(255) default NULL,
  `IMGURL` varchar(255) default NULL,
  PRIMARY KEY  (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `useraccount` */

DROP TABLE IF EXISTS `useraccount`;

CREATE TABLE `useraccount` (
  `ID` int(11) NOT NULL,
  `PASSWORD` varchar(255) default NULL,
  `userid` int(11) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `UK_mvboc4p58q2yjk095tu0m17x` (`userid`),
  CONSTRAINT `FKfoy3ybavhmj1glo370psttu0p` FOREIGN KEY (`userid`) REFERENCES `user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `userbackinfo` */

DROP TABLE IF EXISTS `userbackinfo`;

CREATE TABLE `userbackinfo` (
  `USERBACKINFOID` int(11) NOT NULL,
  `BACKTIME` datetime default NULL,
  `BACKINFO` varchar(255) default NULL,
  `ENGCLASSID` int(11) default NULL,
  `USERID` int(11) default NULL,
  PRIMARY KEY  (`USERBACKINFOID`),
  KEY `FKoykajf26f21slbbk284p2fbl6` (`ENGCLASSID`),
  KEY `FKcksh7whtqht8u46ebsx75uk7v` (`USERID`),
  CONSTRAINT `FKcksh7whtqht8u46ebsx75uk7v` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`),
  CONSTRAINT `FKoykajf26f21slbbk284p2fbl6` FOREIGN KEY (`ENGCLASSID`) REFERENCES `engclass` (`ENGCLASSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `userengclass` */

DROP TABLE IF EXISTS `userengclass`;

CREATE TABLE `userengclass` (
  `ENGCLASSID` int(11) NOT NULL,
  `USERID` int(11) NOT NULL,
  PRIMARY KEY  (`USERID`,`ENGCLASSID`),
  KEY `FKiimer1xie9q2h3x4rxo9yw9rr` (`ENGCLASSID`),
  CONSTRAINT `FKiimer1xie9q2h3x4rxo9yw9rr` FOREIGN KEY (`ENGCLASSID`) REFERENCES `engclass` (`ENGCLASSID`),
  CONSTRAINT `FKindt6b5sr7iplsikc28c1mf7x` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
