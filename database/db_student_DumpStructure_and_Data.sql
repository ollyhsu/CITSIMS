/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : dbstu

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 19/07/2020 13:58:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class` (
  `classId` int NOT NULL AUTO_INCREMENT,
  `className` varchar(50) NOT NULL,
  `specId` int NOT NULL,
  PRIMARY KEY (`classId`),
  KEY `FK_Reference_2` (`specId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`specId`) REFERENCES `tb_spec` (`specId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_class
-- ----------------------------
BEGIN;
INSERT INTO `tb_class` VALUES (1, '1班', 1);
INSERT INTO `tb_class` VALUES (2, '2班', 1);
INSERT INTO `tb_class` VALUES (3, '1班', 2);
INSERT INTO `tb_class` VALUES (4, '1班', 3);
INSERT INTO `tb_class` VALUES (5, '2班', 3);
INSERT INTO `tb_class` VALUES (6, '3班', 3);
INSERT INTO `tb_class` VALUES (7, '1班', 4);
INSERT INTO `tb_class` VALUES (8, '1班', 5);
INSERT INTO `tb_class` VALUES (9, '1班', 6);
INSERT INTO `tb_class` VALUES (10, '2班', 6);
COMMIT;

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `courseId` int NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) NOT NULL,
  `courseScore` double(5,2) NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
BEGIN;
INSERT INTO `tb_course` VALUES (1, '数据结构', 5.00);
INSERT INTO `tb_course` VALUES (2, '数据库原理', 5.00);
INSERT INTO `tb_course` VALUES (3, '软件工程', 3.00);
INSERT INTO `tb_course` VALUES (4, '高等代数', 5.00);
INSERT INTO `tb_course` VALUES (5, '德语', 3.00);
INSERT INTO `tb_course` VALUES (6, '绘画基础', 4.00);
INSERT INTO `tb_course` VALUES (7, '机械原理', 5.00);
COMMIT;

-- ----------------------------
-- Table structure for tb_depart
-- ----------------------------
DROP TABLE IF EXISTS `tb_depart`;
CREATE TABLE `tb_depart` (
  `departId` int NOT NULL AUTO_INCREMENT,
  `departName` varchar(50) NOT NULL,
  PRIMARY KEY (`departId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_depart
-- ----------------------------
BEGIN;
INSERT INTO `tb_depart` VALUES (1, '计算机学院');
INSERT INTO `tb_depart` VALUES (2, '数学学院');
INSERT INTO `tb_depart` VALUES (3, '外国语学院');
INSERT INTO `tb_depart` VALUES (4, '艺术学院');
INSERT INTO `tb_depart` VALUES (5, '自动化学院');
COMMIT;

-- ----------------------------
-- Table structure for tb_score
-- ----------------------------
DROP TABLE IF EXISTS `tb_score`;
CREATE TABLE `tb_score` (
  `scoreId` int NOT NULL AUTO_INCREMENT,
  `courseId` int NOT NULL,
  `stuId` int NOT NULL,
  `score` double(5,2) NOT NULL,
  PRIMARY KEY (`scoreId`),
  KEY `FK_Reference_4` (`courseId`),
  KEY `FK_Reference_5` (`stuId`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`courseId`) REFERENCES `tb_course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`stuId`) REFERENCES `tb_student` (`stuId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_score
-- ----------------------------
BEGIN;
INSERT INTO `tb_score` VALUES (1, 1, 1, 88.00);
INSERT INTO `tb_score` VALUES (2, 1, 2, 99.00);
INSERT INTO `tb_score` VALUES (3, 1, 3, 75.00);
INSERT INTO `tb_score` VALUES (4, 1, 4, 58.00);
INSERT INTO `tb_score` VALUES (5, 1, 5, 80.00);
INSERT INTO `tb_score` VALUES (6, 1, 6, 75.50);
INSERT INTO `tb_score` VALUES (7, 2, 1, 92.00);
INSERT INTO `tb_score` VALUES (8, 2, 2, 81.00);
INSERT INTO `tb_score` VALUES (9, 2, 3, 66.00);
INSERT INTO `tb_score` VALUES (10, 2, 4, 91.00);
INSERT INTO `tb_score` VALUES (11, 2, 5, 88.50);
INSERT INTO `tb_score` VALUES (12, 2, 6, 71.00);
INSERT INTO `tb_score` VALUES (13, 3, 7, 52.00);
INSERT INTO `tb_score` VALUES (14, 3, 8, 82.00);
INSERT INTO `tb_score` VALUES (15, 4, 9, 77.00);
INSERT INTO `tb_score` VALUES (16, 4, 10, 92.00);
INSERT INTO `tb_score` VALUES (17, 4, 11, 81.00);
INSERT INTO `tb_score` VALUES (18, 4, 12, 66.00);
INSERT INTO `tb_score` VALUES (19, 4, 13, 91.00);
INSERT INTO `tb_score` VALUES (20, 4, 14, 88.50);
INSERT INTO `tb_score` VALUES (21, 4, 15, 71.00);
INSERT INTO `tb_score` VALUES (22, 5, 16, 88.00);
INSERT INTO `tb_score` VALUES (23, 5, 17, 95.00);
INSERT INTO `tb_score` VALUES (24, 5, 18, 83.50);
INSERT INTO `tb_score` VALUES (25, 6, 19, 62.50);
INSERT INTO `tb_score` VALUES (26, 6, 20, 76.00);
INSERT INTO `tb_score` VALUES (27, 7, 21, 81.50);
INSERT INTO `tb_score` VALUES (28, 7, 22, 87.00);
INSERT INTO `tb_score` VALUES (29, 7, 23, 94.00);
INSERT INTO `tb_score` VALUES (30, 7, 24, 68.00);
INSERT INTO `tb_score` VALUES (31, 7, 25, 55.00);
COMMIT;

-- ----------------------------
-- Table structure for tb_spec
-- ----------------------------
DROP TABLE IF EXISTS `tb_spec`;
CREATE TABLE `tb_spec` (
  `specId` int NOT NULL AUTO_INCREMENT,
  `specName` varchar(50) NOT NULL,
  `departId` int NOT NULL,
  PRIMARY KEY (`specId`),
  KEY `FK_Reference_3` (`departId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`departId`) REFERENCES `tb_depart` (`departId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_spec
-- ----------------------------
BEGIN;
INSERT INTO `tb_spec` VALUES (1, '计算机科学与技术', 1);
INSERT INTO `tb_spec` VALUES (2, '软件工程', 1);
INSERT INTO `tb_spec` VALUES (3, '数学师范', 2);
INSERT INTO `tb_spec` VALUES (4, '德语', 3);
INSERT INTO `tb_spec` VALUES (5, '服装设计', 4);
INSERT INTO `tb_spec` VALUES (6, '机器人工程', 5);
COMMIT;

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `stuId` int NOT NULL AUTO_INCREMENT,
  `stuName` varchar(50) NOT NULL,
  `stuSex` int NOT NULL DEFAULT '1',
  `stuBirth` date DEFAULT NULL,
  `classId` int NOT NULL,
  PRIMARY KEY (`stuId`),
  KEY `FK_Reference_1` (`classId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`classId`) REFERENCES `tb_class` (`classId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
BEGIN;
INSERT INTO `tb_student` VALUES (1, '张凡', 1, '1999-11-12', 1);
INSERT INTO `tb_student` VALUES (2, '王晨', 1, '2000-01-12', 1);
INSERT INTO `tb_student` VALUES (3, '钱子涵', 1, '2000-01-01', 1);
INSERT INTO `tb_student` VALUES (4, '唐敏', 0, '2000-03-25', 2);
INSERT INTO `tb_student` VALUES (5, '张敏', 0, '1999-12-12', 2);
INSERT INTO `tb_student` VALUES (6, '刘小强', 1, '2000-05-02', 2);
INSERT INTO `tb_student` VALUES (7, '叶子', 0, '2000-02-05', 3);
INSERT INTO `tb_student` VALUES (8, '王迅', 1, '1999-10-15', 3);
INSERT INTO `tb_student` VALUES (9, '赵一凡', 1, '2000-06-07', 4);
INSERT INTO `tb_student` VALUES (10, '郑豪', 1, '1999-07-15', 4);
INSERT INTO `tb_student` VALUES (11, '张艺', 1, '1999-11-28', 4);
INSERT INTO `tb_student` VALUES (12, '刘旭', 1, '1998-10-03', 5);
INSERT INTO `tb_student` VALUES (13, '赵梦飞', 0, '1999-09-13', 5);
INSERT INTO `tb_student` VALUES (14, '任慧', 0, '2000-01-05', 6);
INSERT INTO `tb_student` VALUES (15, '张颖', 0, '2000-04-18', 6);
INSERT INTO `tb_student` VALUES (16, '徐海洋', 1, '2000-02-02', 7);
INSERT INTO `tb_student` VALUES (17, '包晴', 0, '1999-08-12', 7);
INSERT INTO `tb_student` VALUES (18, '王文', 1, '1999-12-18', 7);
INSERT INTO `tb_student` VALUES (19, '严旭', 1, '2000-03-08', 8);
INSERT INTO `tb_student` VALUES (20, '南深', 1, '1999-12-16', 8);
INSERT INTO `tb_student` VALUES (21, '张琪', 0, '2000-10-05', 9);
INSERT INTO `tb_student` VALUES (22, '黄悦', 0, '2000-10-01', 9);
INSERT INTO `tb_student` VALUES (23, '陈泓', 1, '1999-10-14', 10);
INSERT INTO `tb_student` VALUES (24, '王蒙', 0, '2000-06-05', 10);
INSERT INTO `tb_student` VALUES (25, '彭杰', 1, '1999-09-15', 10);
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `userPwd` varchar(50) DEFAULT NULL,
  `userType` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES (1, 'admin', 'admin', 1);
INSERT INTO `tb_user` VALUES (2, 'xhx', 'xhx', 0);
INSERT INTO `tb_user` VALUES (3, 'zcc', '123', 0);
INSERT INTO `tb_user` VALUES (4, 'lisi', '123456', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
