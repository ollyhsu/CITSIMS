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

 Date: 19/07/2020 13:56:48
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `courseId` int NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) NOT NULL,
  `courseScore` double(5,2) NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for tb_depart
-- ----------------------------
DROP TABLE IF EXISTS `tb_depart`;
CREATE TABLE `tb_depart` (
  `departId` int NOT NULL AUTO_INCREMENT,
  `departName` varchar(50) NOT NULL,
  PRIMARY KEY (`departId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
