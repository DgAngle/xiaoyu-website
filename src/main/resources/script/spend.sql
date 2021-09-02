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

 Date: 02/09/2021 15:46:22
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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消费表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spend
-- ----------------------------
INSERT INTO `spend` VALUES (1, 1, '香脆锁骨鸡套餐', 13.99, NULL, '2021-08-30晚：美团外卖\n商家：吧哩吧哩.炸鸡.烤鸡', '2021-08-31 10:28:39', NULL, '味道还可以, 量一般');
INSERT INTO `spend` VALUES (2, 1, '韭菜炒蛋+手撕包菜+米饭', 31.30, NULL, '2021-08-30晚：美团外卖\n商家：十里川香 (大丰收广场店)', '2021-08-31 10:33:19', NULL, '手撕包菜不好吃');
INSERT INTO `spend` VALUES (3, 4, '公司饭卡充值', 100.00, NULL, '2021-08-30：公司饭卡充值', '2021-08-31 12:40:49', NULL, '');
INSERT INTO `spend` VALUES (4, 1, '糖醋里脊+米饭', 27.00, NULL, '2021-08-31晚：美团外卖\n商家：明亮饭店', '2021-09-01 08:40:35', NULL, '味道很一般');
INSERT INTO `spend` VALUES (5, 1, '水果', 18.89, NULL, '2021-08-31晚：美团外卖\n商家：切果NOW! (玲珑湾店)\n【西瓜果切】+【香蕉酸奶捞】+【水果盲盒】+【缤纷果切】', '2021-09-01 08:43:20', NULL, '');
INSERT INTO `spend` VALUES (6, 4, '手机话费', 50.00, NULL, '2021-09-01：支付宝手机充话费', '2021-09-02 08:31:22', NULL, '');
INSERT INTO `spend` VALUES (7, 1, '韭菜炒蛋+米饭', 18.28, NULL, '2021-09-01晚：美团外卖\n商家：十里川 香（大丰收广场店）', '2021-09-02 08:33:21', NULL, '');
INSERT INTO `spend` VALUES (8, 1, '回锅肉盖浇饭+手撕包菜', 28.00, NULL, '2021-09-01晚：美团外卖\n商家：明亮饭店', '2021-09-02 08:34:15', NULL, '');
INSERT INTO `spend` VALUES (9, 2, '王者皮肤', 45.00, NULL, '2021-09-01晚：王者荣耀充值45元【QQ区】\n购买【伽罗】55开黑节皮肤【箭羽风息】【44.4】元', '2021-09-02 08:39:20', NULL, '');

SET FOREIGN_KEY_CHECKS = 1;
