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

 Date: 09/09/2021 18:01:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for note_cat
-- ----------------------------
DROP TABLE IF EXISTS `note_cat`;
CREATE TABLE `note_cat`  (
  `noteCatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `noteCatName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `noteCatNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '笔记分类编号,四位一级,例：000100010001',
  `parentNoteCatId` bigint(20) NULL DEFAULT NULL COMMENT '父级主键',
  `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `parentNoteCatNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级编号',
  PRIMARY KEY (`noteCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of note_cat
-- ----------------------------
INSERT INTO `note_cat` VALUES (1, '学习笔记', '0001', 0, 10, '2021-09-06 08:53:40', '', NULL);
INSERT INTO `note_cat` VALUES (2, '工作笔记', '0002', 0, 0, '2021-09-06 08:53:50', '', NULL);
INSERT INTO `note_cat` VALUES (3, '道家玄学', '0003', 0, 0, '2021-09-06 08:54:14', '', NULL);
INSERT INTO `note_cat` VALUES (4, '项目笔记', '0004', 0, 0, '2021-09-06 08:54:46', '', NULL);
INSERT INTO `note_cat` VALUES (5, 'Java学习', '00010001', 1, 0, '2021-09-06 09:00:32', '', '0001');
INSERT INTO `note_cat` VALUES (6, '杂事百科', '0005', 0, 0, '2021-09-06 09:17:42', '', NULL);
INSERT INTO `note_cat` VALUES (7, '句子笔记', '0006', 0, 0, '2021-09-06 10:59:55', '', NULL);
INSERT INTO `note_cat` VALUES (8, 'Bug笔记', '0007', 0, 4, '2021-09-06 11:12:55', '', NULL);
INSERT INTO `note_cat` VALUES (9, '国贸酝领', '00020001', 2, 0, '2021-09-09 14:06:32', '', '0002');

SET FOREIGN_KEY_CHECKS = 1;
