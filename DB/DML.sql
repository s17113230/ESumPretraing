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

 Date: 02/08/2023 02:25:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of seatingchart
-- ----------------------------
INSERT INTO `seatingchart` VALUES (1, 1, 1);
INSERT INTO `seatingchart` VALUES (2, 1, 2);
INSERT INTO `seatingchart` VALUES (3, 1, 3);
INSERT INTO `seatingchart` VALUES (4, 1, 4);
INSERT INTO `seatingchart` VALUES (5, 2, 1);
INSERT INTO `seatingchart` VALUES (6, 2, 2);
INSERT INTO `seatingchart` VALUES (7, 2, 3);
INSERT INTO `seatingchart` VALUES (8, 2, 4);
INSERT INTO `seatingchart` VALUES (9, 3, 1);
INSERT INTO `seatingchart` VALUES (10, 3, 2);
INSERT INTO `seatingchart` VALUES (11, 3, 3);
INSERT INTO `seatingchart` VALUES (12, 3, 4);
INSERT INTO `seatingchart` VALUES (13, 4, 1);
INSERT INTO `seatingchart` VALUES (14, 4, 2);
INSERT INTO `seatingchart` VALUES (15, 4, 3);
INSERT INTO `seatingchart` VALUES (16, 4, 4);
-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '張雲峰', 'zhangyunfeng@example.com', NULL);
INSERT INTO `employee` VALUES (2, '李天然', 'litianran@example.com', NULL);
INSERT INTO `employee` VALUES (3, '王思遠', 'wangsiyuan@example.com', NULL);
INSERT INTO `employee` VALUES (4, '趙心怡', 'zhaoxinyi@example.com', NULL);
INSERT INTO `employee` VALUES (5, '陳俊宇', 'chenjunyu@example.com', NULL);
INSERT INTO `employee` VALUES (6, '林雅鈴', 'linyaling@example.com', NULL);
INSERT INTO `employee` VALUES (7, '吳佳芸', 'wujiayun@example.com', NULL);
INSERT INTO `employee` VALUES (8, '鄭文婷', 'zhengwenting@example.com', NULL);
INSERT INTO `employee` VALUES (9, '周昊宇', 'zhouhaoyu@example.com', NULL);
INSERT INTO `employee` VALUES (10, '劉美娟', 'liumeijuan@example.com', NULL);
INSERT INTO `employee` VALUES (11, '陸俊杰', 'lujunjie@example.com', NULL);
INSERT INTO `employee` VALUES (12, '金潔心', 'jinjiexin@example.com', 12);
INSERT INTO `employee` VALUES (13, '陳雅琪', 'chenyaqi@example.com', NULL);
INSERT INTO `employee` VALUES (14, '馮宏偉', 'fenghongwei@example.com', NULL);
INSERT INTO `employee` VALUES (15, '黃雨薇', 'huangyuwei@example.com', NULL);
INSERT INTO `employee` VALUES (16, '曹俊逸', 'caojunyi@example.com', NULL);
INSERT INTO `employee` VALUES (17, '魏雅芳', 'weiyafang@example.com', NULL);
INSERT INTO `employee` VALUES (101, '蔡正宏', 'caizhenghong@example.com', NULL);
INSERT INTO `employee` VALUES (1001, '賈春雨', 'jiachunyu@example.com', 15);
INSERT INTO `employee` VALUES (10001, '錢嘉玲', 'qianjialing@example.com', 6);

SET FOREIGN_KEY_CHECKS = 1;
