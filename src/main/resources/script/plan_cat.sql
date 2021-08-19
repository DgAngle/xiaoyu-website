/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : xiaoyu_website

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 19/08/2021 17:25:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for plan_cat
-- ----------------------------
DROP TABLE IF EXISTS `plan_cat`;
CREATE TABLE `plan_cat`  (
  `planCatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划主键',
  `planCatName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT ' 计划分类名称',
  `orderNum` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '排序号',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`planCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '计划分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_cat
-- ----------------------------
INSERT INTO `plan_cat` VALUES (1, '今日计划', 0000000010, '2021-08-19 13:30:39', NULL);
INSERT INTO `plan_cat` VALUES (2, '长期计划', 0000000000, '2021-08-19 13:30:50', NULL);
INSERT INTO `plan_cat` VALUES (3, '短期计划', 0000000000, '2021-08-19 13:30:57', NULL);

SET FOREIGN_KEY_CHECKS = 1;
