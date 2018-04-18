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
  `account_id` int(10) NOT NULL,
  `account_password` varchar(18) NOT NULL,
  `account_role_id` int(10) NOT NULL,
  `account_role` varchar(2) NOT NULL,
  PRIMARY KEY  (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for system_account
-- ----------------------------
DROP TABLE IF EXISTS `system_account`;
CREATE TABLE `system_account` (
  `sys_id` int(11) NOT NULL,
  `sys_password` varchar(18) NOT NULL,
  PRIMARY KEY  (`sys_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(15) NOT NULL,
  `course_info` varchar(50) NOT NULL,
  `course_type` varchar(10) NOT NULL,
  `course_price` float(10,2) NOT NULL,
  `course_img_url` varchar(50) default NULL,
  PRIMARY KEY  (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course_record
-- ----------------------------
DROP TABLE IF EXISTS `course_record`;
CREATE TABLE `course_record` (
  `course_record_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `course_start_time` datetime default NULL,
  `course_end_time` datetime default NULL,
  `course_close_time` datetime default NULL,
  `course_sign_count` int(11) default '0',
  PRIMARY KEY  (`course_record_id`),
  KEY `fk_course_id` (`course_id`),
  CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `course_record` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(10) NOT NULL,
  `user_age` int(11) default NULL,
  `user_id_card` varchar(18) NOT NULL,
  `user_sex` varchar(5) default NULL,
  `user_img_url` varchar(50) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
  `teacher_id_card` varchar(18) NOT NULL,
  `teacher_name` varchar(10) NOT NULL,
  `teacher_sex` varchar(5) default NULL,
  `teacher_age` int(11) default NULL,
  `teacher_phone` varchar(13) NOT NULL,
  `teacher_address` varchar(50) NOT NULL,
  `teacher_img_url` varchar(50) default NULL,
  PRIMARY KEY  (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `course_record_id` int(11) NOT NULL,
  `class_name` varchar(50) default NULL,
  `student_count` varchar(50) default NULL,
  `classroom` varchar(50) default NULL,
  PRIMARY KEY  (`class_id`),
  KEY `fk_teacher_id` (`teacher_id`),
  KEY `fk_course_record_id` (`course_record_id`),
  CONSTRAINT `fk_course_record_id` FOREIGN KEY (`course_record_id`) REFERENCES `course_record` (`course_record_id`),
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for user_class
-- ----------------------------
DROP TABLE IF EXISTS `user_class`;
CREATE TABLE `user_class` (
  `user_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `is_ assigned` int(2) NOT NULL,
  PRIMARY KEY  (`user_id`,`class_id`),
  KEY `fk_class_id` (`class_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher_back_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_back_info`;
CREATE TABLE `teacher_back_info` (
  `teacher_back_id` int(11) NOT NULL,
  `teacher_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `class_id` int(11) default NULL,
  `back_time` datetime default NULL,
  `back_info` varchar(50) default NULL,
  PRIMARY KEY  (`teacher_back_id`),
  KEY `fk1_teacher_id` (`teacher_id`),
  KEY `fk1_user_id` (`user_id`),
  KEY `fk1_class_id` (`class_id`),
  CONSTRAINT `fk1_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `fk1_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `fk1_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for user_back_info
-- ----------------------------
DROP TABLE IF EXISTS `user_back_info`;
CREATE TABLE `user_back_info` (
  `user_back_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `back_time` datetime default NULL,
  `back_info` varchar(50) default NULL,
  PRIMARY KEY  (`user_back_id`),
  KEY `fk2_teacher_id` (`teacher_id`),
  KEY `fk2_user_id` (`user_id`),
  KEY `fk2_class_id` (`class_id`),
  CONSTRAINT `fk2_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `fk2_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `fk2_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for time_sheet
-- ----------------------------
DROP TABLE IF EXISTS `time_sheet`;
CREATE TABLE `time_sheet` (
  `time_sheet_id` int(11) NOT NULL default '0',
  `user_id` int(11) default NULL,
  `class_id` int(11) default NULL,
  `record_time` datetime default NULL,
  `sheet_info` varchar(50) default NULL,
  PRIMARY KEY  (`time_sheet_id`),
  KEY `fk3_user_id` (`user_id`),
  KEY `fk3_class_id` (`class_id`),
  CONSTRAINT `fk3_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk3_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
