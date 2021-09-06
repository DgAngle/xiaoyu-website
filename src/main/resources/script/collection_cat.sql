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

 Date: 06/09/2021 18:09:35
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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection_cat
-- ----------------------------
INSERT INTO `collection_cat` VALUES (1, '网站收藏', 8, '2021-08-16 13:10:38', NULL);
INSERT INTO `collection_cat` VALUES (2, '思维导图', 0, '2021-08-16 13:11:01', NULL);
INSERT INTO `collection_cat` VALUES (3, '在线学习', 6, '2021-08-16 13:11:08', NULL);
INSERT INTO `collection_cat` VALUES (4, '在线阅读', 10, '2021-08-16 13:11:23', NULL);
INSERT INTO `collection_cat` VALUES (5, '在线笔记', 0, '2021-08-16 13:12:14', NULL);
INSERT INTO `collection_cat` VALUES (6, '资源下载', 0, '2021-08-16 13:17:24', NULL);
INSERT INTO `collection_cat` VALUES (7, '在线文档', 0, '2021-08-16 13:20:02', NULL);
INSERT INTO `collection_cat` VALUES (8, '在线工具', 0, '2021-08-16 13:39:38', NULL);
INSERT INTO `collection_cat` VALUES (9, '博客知识', 0, '2021-08-16 14:59:21', NULL);
INSERT INTO `collection_cat` VALUES (10, '插件收藏', 1, '2021-08-19 15:04:41', NULL);
INSERT INTO `collection_cat` VALUES (11, '在线娱乐', 0, '2021-08-23 16:04:57', NULL);
INSERT INTO `collection_cat` VALUES (12, '道家玄学', 8, '2021-09-06 09:55:00', NULL);

SET FOREIGN_KEY_CHECKS = 1;
