/*
 Navicat Premium Data Transfer

 Source Server         : a
 Source Server Type    : MySQL
 Source Server Version : 100427 (10.4.27-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : esum

 Target Server Type    : MySQL
 Target Server Version : 100427 (10.4.27-MariaDB)
 File Encoding         : 65001

 Date: 02/08/2023 02:25:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for seatingchart
-- ----------------------------
DROP TABLE IF EXISTS `seatingchart`;
CREATE TABLE `seatingchart`  (
  `FLOOR_SEAT_SEQ` int NOT NULL AUTO_INCREMENT,
  `FLOOR_NO` int NOT NULL,
  `SEAT_NO` int NOT NULL,
  PRIMARY KEY (`FLOOR_SEAT_SEQ`) USING BTREE,
  UNIQUE INDEX `constraint_seating_floor_seat`(`FLOOR_NO` ASC, `SEAT_NO` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `EMP_ID` int NOT NULL,
  `NAME` char(20) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci NOT NULL,
  `EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci NOT NULL,
  `FLOOR_SEAT_SEQ` int NULL DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`) USING BTREE,
  UNIQUE INDEX `EMAIL`(`EMAIL` ASC) USING BTREE,
  INDEX `FLOOR_SEAT_SEQ`(`FLOOR_SEAT_SEQ` ASC) USING BTREE,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`FLOOR_SEAT_SEQ`) REFERENCES `seatingchart` (`FLOOR_SEAT_SEQ`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_520_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
