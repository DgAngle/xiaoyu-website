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

 Date: 25/08/2021 13:02:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan`  (
  `planId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划主键',
  `planName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划名称',
  `planCatId` int(11) NULL DEFAULT NULL COMMENT '计划分类',
  `planContent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划内容',
  `planStartDt` datetime NULL DEFAULT NULL COMMENT '计划开始时间',
  `planEndDt` datetime NULL DEFAULT NULL COMMENT '计划结束时间',
  `status` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '执行状态',
  `planFinishedDt` datetime NULL DEFAULT NULL COMMENT '计划完成时间',
  `updateDt` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `updateBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`planId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '计划表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
