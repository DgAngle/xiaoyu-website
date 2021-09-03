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

 Date: 03/09/2021 18:29:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for spend_cat
-- ----------------------------
DROP TABLE IF EXISTS `spend_cat`;
CREATE TABLE `spend_cat`  (
  `spendCatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消费分类主键',
  `spendCatName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消费分类名称',
  `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`spendCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消费分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spend_cat
-- ----------------------------
INSERT INTO `spend_cat` VALUES (1, '吃喝', 0, '2021-08-31 10:13:37', NULL);
INSERT INTO `spend_cat` VALUES (2, '游戏', 0, '2021-08-31 10:13:43', NULL);
INSERT INTO `spend_cat` VALUES (3, '出行', 0, '2021-08-31 10:13:48', NULL);
INSERT INTO `spend_cat` VALUES (4, '生活', 0, '2021-09-02 08:30:38', NULL);

SET FOREIGN_KEY_CHECKS = 1;
