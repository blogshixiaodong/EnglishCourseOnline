/*
Navicat MySQL Data Transfer

Source Server         : EnglishCourseOnline
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : englishcourseonline

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2018-04-19 00:13:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(10) NOT NULL,
  `password` varchar(18) NOT NULL,
  `roleid` int(10) NOT NULL,
  `role` varchar(2) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for system_account
-- ----------------------------
DROP TABLE IF EXISTS `system_account`;
CREATE TABLE `system_account` (
  `id` int(11) NOT NULL,
  `password` varchar(18) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseid` int(11) NOT NULL,
  `coursename` varchar(15) NOT NULL,
  `info` varchar(50) NOT NULL,
  `type` varchar(10) NOT NULL,
  `price` float(10,2) NOT NULL,
  `imgurl` varchar(50) default NULL,
  PRIMARY KEY  (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course_record
-- ----------------------------
DROP TABLE IF EXISTS `course_record`;
CREATE TABLE `course_record` (
  `courserecordid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL,
  `starttime` datetime default NULL,
  `endtime` datetime default NULL,
  `closetime` datetime default NULL,
  `signcount` int(11) default '0',
  PRIMARY KEY  (`courserecordid`),
  CONSTRAINT `fk_course_id` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL auto_increment,
  `username` varchar(10) NOT NULL,
  `age` int(11) default NULL,
  `idcard` varchar(18) NOT NULL,
  `sex` varchar(5) default NULL,
  `imgurl` varchar(50) default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherid` int(11) NOT NULL,
  `idcard` varchar(18) NOT NULL,
  `name` varchar(10) NOT NULL,
  `sex` varchar(5) default NULL,
  `age` int(11) default NULL,
  `phone` varchar(13) NOT NULL,
  `address` varchar(50) NOT NULL,
  `imgurl` varchar(50) default NULL,
  PRIMARY KEY  (`teacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classid` int(11) NOT NULL,
  `teacherid` int(11) NOT NULL,
  `courserecordid` int(11) NOT NULL,
  `classname` varchar(50) default NULL,
  `usercount` int(11) default NULL,
  `classroom` varchar(50) default NULL,
  PRIMARY KEY  (`classid`),
  CONSTRAINT `fk_course_record_id` FOREIGN KEY (`courserecordid`) REFERENCES `course_record` (`courserecordid`),
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`teacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for user_class
-- ----------------------------
DROP TABLE IF EXISTS `user_class`;
CREATE TABLE `user_class` (
  `userid` int(11) NOT NULL,
  `classid` int(11) NOT NULL,
  `isassigned` int(2) NOT NULL,
  PRIMARY KEY  (`userid`,`classid`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `fk_class_id` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher_back_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_back_info`;
CREATE TABLE `teacher_back_info` (
  `teacherbackid` int(11) NOT NULL,
  `teacherid` int(11) default NULL,
  `userid` int(11) default NULL,
  `classid` int(11) default NULL,
  `backtime` datetime default NULL,
  `backinfo` varchar(50) default NULL,
  PRIMARY KEY  (`teacherbackid`),
  CONSTRAINT `fk1_class_id` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`),
  CONSTRAINT `fk1_teacher_id` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`teacherid`),
  CONSTRAINT `fk1_user_id` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for user_back_info
-- ----------------------------
DROP TABLE IF EXISTS `user_back_info`;
CREATE TABLE `user_back_info` (
  `userbackid` int(11) NOT NULL,
  `teacherid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `classid` int(11) NOT NULL,
  `backtime` datetime default NULL,
  `backinfo` varchar(50) default NULL,
  PRIMARY KEY  (`userbackid`),
  CONSTRAINT `fk2_class_id` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`),
  CONSTRAINT `fk2_teacher_id` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`teacherid`),
  CONSTRAINT `fk2_user_id` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for time_sheet
-- ----------------------------
DROP TABLE IF EXISTS `time_sheet`;
CREATE TABLE `time_sheet` (
  `timesheetid` int(11) NOT NULL default '0',
  `userid` int(11) default NULL,
  `classid` int(11) default NULL,
  `recordtime` datetime default NULL,
  `sheetinfo` varchar(50) default NULL,
  PRIMARY KEY  (`timesheetid`),
  CONSTRAINT `fk3_user_id` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `fk3_class_id` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
