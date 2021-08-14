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

 Date: 14/08/2021 16:19:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collection_cat
-- ----------------------------
DROP TABLE IF EXISTS `collection_cat`;
CREATE TABLE `collection_cat`  (
  `collectionCatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收藏分类主键',
  `collectionCatName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收藏分类名称',
  `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`collectionCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection_cat
-- ----------------------------
INSERT INTO `collection_cat` VALUES (1, '网站收藏', 0, '2021-08-12 14:41:09', NULL);
INSERT INTO `collection_cat` VALUES (2, '思维导图', 0, '2021-08-12 14:43:00', NULL);
INSERT INTO `collection_cat` VALUES (3, '在线学习', 0, '2021-08-12 14:43:11', NULL);
INSERT INTO `collection_cat` VALUES (4, '在线阅读', 0, '2021-08-12 15:12:44', NULL);

SET FOREIGN_KEY_CHECKS = 1;
