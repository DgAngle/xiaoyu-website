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

 Date: 08/09/2021 17:37:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for spend
-- ----------------------------
DROP TABLE IF EXISTS `spend`;
CREATE TABLE `spend`  (
  `spendId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消费主键',
  `spendCatId` bigint(20) NULL DEFAULT NULL COMMENT '消费分类主键',
  `spendName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消费名称',
  `spendMoney` decimal(18, 2) NULL DEFAULT NULL COMMENT '消费金额',
  `spendDate` datetime NULL DEFAULT NULL COMMENT '消费时间',
  `spendContent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消费内容',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`spendId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消费表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spend
-- ----------------------------
INSERT INTO `spend` VALUES (1, 1, '香脆锁骨鸡套餐', 13.99, '2021-08-30 19:00:00', '平台：美团外卖\n商家：吧哩吧哩.炸鸡.烤鸡', '2021-08-31 10:28:39', NULL, '时间：2021-08-30晚\n评价：味道还可以, 量一般');
INSERT INTO `spend` VALUES (2, 1, '韭菜炒蛋+手撕包菜+米饭', 31.30, '2021-08-30 19:00:00', '平台：美团外卖\n商家：十里川香 (大丰收广场店)', '2021-08-31 10:33:19', NULL, '时间：2021-08-30晚\n评价：手撕包菜不好吃');
INSERT INTO `spend` VALUES (3, 4, '公司饭卡充值', 100.00, '2021-08-30 11:00:00', '内容：公司饭卡充值', '2021-08-31 12:40:49', NULL, '');
INSERT INTO `spend` VALUES (4, 1, '糖醋里脊+米饭', 27.00, '2021-08-31 19:00:00', '平台：美团外卖\n商家：明亮饭店', '2021-09-01 08:40:35', NULL, '时间：2021-08-31晚\n评价：味道很一般');
INSERT INTO `spend` VALUES (5, 1, '水果', 18.89, '2021-08-31 19:00:00', '平台：美团外卖\n商家：切果NOW! (玲珑湾店)\n明细：【西瓜果切】+【香蕉酸奶捞】+【水果盲盒】+【缤纷果切】', '2021-09-01 08:43:20', NULL, '时间：2021-08-31晚');
INSERT INTO `spend` VALUES (6, 4, '手机话费', 50.00, '2021-09-01 20:00:00', '内容：支付宝手机充话费', '2021-09-02 08:31:22', NULL, '');
INSERT INTO `spend` VALUES (7, 1, '韭菜炒蛋+米饭', 18.28, '2021-09-01 19:00:00', '平台：美团外卖\n商家：十里川 香（大丰收广场店）', '2021-09-02 08:33:21', NULL, '时间：2021-09-01晚');
INSERT INTO `spend` VALUES (8, 1, '回锅肉盖浇饭+手撕包菜', 28.00, '2021-09-01 20:00:00', '平台：美团外卖\n商家：明亮饭店', '2021-09-02 08:34:15', NULL, '时间：2021-09-01晚');
INSERT INTO `spend` VALUES (9, 2, '王者皮肤', 45.00, '2021-09-01 20:00:00', '游戏：王者荣耀充值45元【QQ区】\n内容：购买【伽罗】55开黑节皮肤【箭羽风息】【44.4】元', '2021-09-02 08:39:20', NULL, '时间：2021-09-01晚');
INSERT INTO `spend` VALUES (10, 1, '香脆锁骨鸡', 14.99, '2021-09-02 20:00:00', '平台：美团外卖\n商家：吧哩吧哩.炸鸡.烤鸡（青剑湖店）', '2021-09-03 09:31:07', NULL, '');
INSERT INTO `spend` VALUES (11, 1, '炸串卷饼', 20.58, '2021-09-03 19:00:00', '平台：美团外卖\n商家：于飞成卷饼炸串拌饼（曼哈顿店）\n明细：【拌饼，2.98】+【金丝纯肉排，6.58】+【棒棒鸡，5.58】+【韭菜，2.98】\n           【兰花干，4.58】+【长沙黑色经典灌汤臭豆腐，12】+【热狗，3.58->0.1】', '2021-09-04 09:45:51', NULL, '');
INSERT INTO `spend` VALUES (12, 1, '回锅肉盖浇饭+蒜苔肉丝', 27.00, '2021-09-03 19:00:00', '平台：美团外卖\n商家：明亮饭店', '2021-09-04 09:48:22', NULL, '');
INSERT INTO `spend` VALUES (13, 1, '京东消费', 240.41, '2021-09-04 20:00:00', '平台：京东商城\n明细：【卡士.鲜酪乳，27】+【...】', '2021-09-05 11:58:47', NULL, NULL);
INSERT INTO `spend` VALUES (14, 1, '黄焖鸡米饭', 17.46, '2021-09-05 11:00:00', '平台：饿了吗\n', '2021-09-05 11:59:38', NULL, NULL);
INSERT INTO `spend` VALUES (15, 5, '京东白条还款', 1432.65, '2021-09-05 12:00:00', '平台：京东商城\n', '2021-09-05 12:00:48', NULL, NULL);
INSERT INTO `spend` VALUES (16, 6, '迅雷会员', 8.90, '2021-09-05 20:00:00', '平台：迅雷\n明细：一个月白金会员', '2021-09-06 08:39:39', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
