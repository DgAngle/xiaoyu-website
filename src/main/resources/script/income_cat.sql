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

 Date: 08/09/2021 17:37:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for income_cat
-- ----------------------------
DROP TABLE IF EXISTS `income_cat`;
CREATE TABLE `income_cat`  (
  `incomeCatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收入分类主键',
  `incomeCatName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入分类名称',
  `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`incomeCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收入分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of income_cat
-- ----------------------------
INSERT INTO `income_cat` VALUES (7, '工资', 0, '2021-09-07 12:58:03', NULL);
INSERT INTO `income_cat` VALUES (8, '余额', 0, '2021-09-07 12:59:13', NULL);
INSERT INTO `income_cat` VALUES (9, '消费', 0, '2021-09-07 13:09:06', NULL);

SET FOREIGN_KEY_CHECKS = 1;
