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

 Date: 08/09/2021 17:37:36
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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '计划表' ROW_FORMAT = Dynamic;

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
INSERT INTO `plan` VALUES (10, '市政府2期设备接口开发-未测试', 4, '标题：市政府2期设备对外接口开发\n内容：\n    1. 大数据接口测试不通\n    2. 二维码接口参数不知道填啥\n    3. 需要跟访客机联调，测试相关流程，包含（添加预约，发送公安，下发门禁）等测试点', NULL, NULL, 2, NULL, '2021-08-30 13:11:28', NULL, '2021-08-30 13:11:28', NULL, '');
INSERT INTO `plan` VALUES (11, '每日三省', 1, '一省自身不足\n二省灵魂自问\n三省改进自身', NULL, NULL, 2, NULL, '2021-08-30 13:41:21', NULL, '2021-08-30 13:41:21', NULL, '');
INSERT INTO `plan` VALUES (12, '购物', 1, '【衬衣】+【鞋子：雨天防滑】+【针线】+【...】', NULL, NULL, 2, NULL, '2021-09-06 08:40:49', NULL, '2021-09-06 08:40:49', NULL, '');
INSERT INTO `plan` VALUES (13, '笔记功能完善', 3, '1. 主页笔记可以点击跳转到详情\n2. 前期详情直接做，后期使用markdown', NULL, NULL, 2, NULL, '2021-09-06 11:19:15', NULL, '2021-09-06 11:19:15', NULL, '');
INSERT INTO `plan` VALUES (14, '小羽项目之登录功能', 3, '1. 添加登录功能\n2. 各个功能加上人员权限', NULL, NULL, 2, NULL, '2021-09-06 13:29:06', NULL, '2021-09-06 13:29:06', NULL, '');
INSERT INTO `plan` VALUES (15, '苏停车3个功能目标', 4, '项目：苏停车\n因素：相关MySQL数据表数据量超过1000万\n目标1：统计查询超过30秒优化\n目标2：查询在某个时间段内，那个车牌付费最多（点击可以查看明细）\n目标3：查询某个停车场消费最高，及其停车次数', NULL, NULL, 2, NULL, '2021-09-06 14:25:16', NULL, '2021-09-06 14:25:16', NULL, '');
INSERT INTO `plan` VALUES (16, 'LOGO设计', 1, '1. 动物LOGO\n2. 植物LOGO\n3. 星空LOGO', NULL, NULL, 2, NULL, '2021-09-07 10:58:07', NULL, '2021-09-07 10:58:07', NULL, '');

SET FOREIGN_KEY_CHECKS = 1;
