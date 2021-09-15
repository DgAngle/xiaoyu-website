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

 Date: 08/09/2021 17:37:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income`  (
  `incomeId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收入主键',
  `incomeCatId` bigint(20) NULL DEFAULT NULL COMMENT '收入分类主键',
  `incomeName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入名称',
  `incomeMoney` decimal(18, 2) NULL DEFAULT NULL COMMENT '收入金额',
  `incomeDate` datetime NULL DEFAULT NULL COMMENT '收入时间',
  `incomeContent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入内容',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`incomeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收入表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES (17, 8, '截至2021-09-07苏州银行余额', 5599.01, '2021-09-07 13:00:00', '银行：苏州银行\n明细：工资余额', '2021-09-07 13:01:21', NULL, NULL);
INSERT INTO `income` VALUES (18, 8, '截至2021-09-07支付宝账户余额', 1166.91, '2021-09-07 13:00:00', '平台：支付宝->余额宝\n', '2021-09-07 13:02:52', NULL, NULL);
INSERT INTO `income` VALUES (19, 8, '截至2021-09-07交通银行余额', 2141.51, '2021-09-07 13:00:00', '银行：交通银行\n明细：账户余额', '2021-09-07 13:04:44', NULL, NULL);
INSERT INTO `income` VALUES (20, 8, '截至2021-09-07工商银行余额', 8.43, '2021-09-07 13:00:00', '银行：工商银行\n明细：账户余额', '2021-09-07 13:06:13', NULL, NULL);
INSERT INTO `income` VALUES (21, 9, '2021-08-30至2021-09-07累计消费', 2094.45, '2021-09-07 13:00:00', '累计消费', '2021-09-07 13:08:43', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
