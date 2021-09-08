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

 Date: 08/09/2021 17:37:43
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
  `orderNum` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '排序号',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`planCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '计划分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_cat
-- ----------------------------
INSERT INTO `plan_cat` VALUES (1, '每日计划', 8, '2021-08-19 13:30:39', NULL);
INSERT INTO `plan_cat` VALUES (2, '长期计划', 0, '2021-08-19 13:30:50', NULL);
INSERT INTO `plan_cat` VALUES (3, '短期计划', 2, '2021-08-19 13:30:57', NULL);
INSERT INTO `plan_cat` VALUES (4, '工作计划', 10, '2021-08-26 14:38:18', NULL);
INSERT INTO `plan_cat` VALUES (5, '学习计划', 6, '2021-08-26 14:59:14', NULL);

SET FOREIGN_KEY_CHECKS = 1;
