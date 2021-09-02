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

 Date: 02/09/2021 15:46:34
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
  `status` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '执行状态',
  `planFinishedDt` datetime NULL DEFAULT NULL COMMENT '计划完成时间',
  `updateDt` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `updateBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`planId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '计划表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES (1, '物联网大屏', 4, NULL, NULL, NULL, 2, NULL, '2021-08-26 14:38:50', NULL, '2021-08-26 14:38:50', NULL, '');
INSERT INTO `plan` VALUES (2, 'Spring源码学习', 5, NULL, NULL, NULL, 2, NULL, '2021-08-26 14:59:52', NULL, '2021-08-26 14:59:52', NULL, '');
INSERT INTO `plan` VALUES (3, '停车系统中行接口对接', 4, '对接中国银行接口，通过请求对账单下载接口获取文件，解析并插入数据库', NULL, NULL, 8, NULL, '2021-08-26 15:02:40', NULL, '2021-08-26 15:02:40', NULL, '');
INSERT INTO `plan` VALUES (4, '背20个单词', 1, NULL, NULL, NULL, 2, NULL, '2021-08-26 15:10:00', NULL, '2021-08-26 15:10:00', NULL, '');
INSERT INTO `plan` VALUES (5, '前端学习之Vue', 5, NULL, NULL, NULL, 4, NULL, '2021-08-26 15:13:17', NULL, '2021-08-26 15:13:17', NULL, '');
INSERT INTO `plan` VALUES (6, '前端学习之Jquery', 5, NULL, NULL, NULL, 5, NULL, '2021-08-26 15:13:34', NULL, '2021-08-26 15:13:34', NULL, '');
INSERT INTO `plan` VALUES (7, '后端学习之Mybatis', 5, NULL, NULL, NULL, 0, NULL, '2021-08-26 15:13:54', NULL, '2021-08-26 15:13:54', NULL, '');
INSERT INTO `plan` VALUES (8, '中行账单手动导入字段更新', 4, 'elifeweb中手动导入中国银行没有更新sysparameter表中的中国银行最后一次更新字段，需要调整', NULL, NULL, 8, NULL, '2021-08-27 16:15:03', NULL, '2021-08-27 16:15:03', NULL, '');
INSERT INTO `plan` VALUES (9, '缓存实战学习', 5, '缓存实战学习', NULL, NULL, 2, NULL, '2021-08-30 13:09:38', NULL, '2021-08-30 13:09:38', NULL, '');
INSERT INTO `plan` VALUES (10, '市政府2期设备接口开发', 4, '市政府2期设备对外接口开发', NULL, NULL, 2, NULL, '2021-08-30 13:11:28', NULL, '2021-08-30 13:11:28', NULL, '');
INSERT INTO `plan` VALUES (11, '每日三省', 1, '一省自身不足\n二省灵魂自问\n三省改进自身', NULL, NULL, 2, NULL, '2021-08-30 13:41:21', NULL, '2021-08-30 13:41:21', NULL, '');

SET FOREIGN_KEY_CHECKS = 1;
