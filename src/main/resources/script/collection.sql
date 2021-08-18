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

 Date: 18/08/2021 17:34:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `collectionId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收藏主键',
  `collectionName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收藏名称',
  `collectionUrl` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收藏地址',
  `collectionCatId` bigint(20) NULL DEFAULT NULL COMMENT '收藏分类主键',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`collectionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (1, 'RedSpider社区', 'http://concurrent.redspider.group/RedSpider.html', 4, '多线程相关内容', '2021-08-16 10:14:35', '');
INSERT INTO `collection` VALUES (2, '凤凰架构', 'https://icyfenix.cn/', 4, '如何构建可靠的大型分布式系统', '2021-08-16 10:40:12', NULL);
INSERT INTO `collection` VALUES (3, 'Bootstrap4', 'https://v4.bootcss.com/', 1, 'Bootstrap4官网', '2021-08-16 10:41:35', NULL);
INSERT INTO `collection` VALUES (4, 'Leetcode', 'https://leetcode-cn.com/', 3, '算法学习以及练习网站', '2021-08-16 12:48:11', NULL);
INSERT INTO `collection` VALUES (5, 'Tomcat下载', 'https://archive.apache.org/dist/tomcat/', 6, 'Tomcat历史版本下载', '2021-08-16 13:17:45', NULL);
INSERT INTO `collection` VALUES (6, 'JQuery在线中文文档', 'https://jquery.cuishifeng.cn/', 7, 'JQuery 在线Api', '2021-08-16 13:21:45', NULL);
INSERT INTO `collection` VALUES (7, 'fontawesome', 'https://fontawesome.dashgame.com/', 1, 'fontawesome字体图标官网', '2021-08-16 13:22:56', NULL);
INSERT INTO `collection` VALUES (8, 'Google翻译', 'https://translate.google.cn/', 8, 'Google 在线翻译', '2021-08-16 13:40:36', NULL);
INSERT INTO `collection` VALUES (9, '有道翻译', 'https://fanyi.youdao.com/', 8, '有道云在线翻译', '2021-08-16 13:40:58', NULL);
INSERT INTO `collection` VALUES (10, 'ProcessOn', 'https://www.processon.com/', 5, 'ProcessOn在线流程图、脑图笔记', '2021-08-16 14:14:09', NULL);
INSERT INTO `collection` VALUES (11, 'iconfont-阿里巴巴矢量图标库', 'https://www.iconfont.cn/search/index', 1, 'iconfont-阿里巴巴矢量图标库官方网站', '2021-08-16 14:30:39', NULL);
INSERT INTO `collection` VALUES (12, 'CSDN', 'https://www.csdn.net/', 1, 'CSDN-IT博客网站', '2021-08-16 14:32:47', NULL);
INSERT INTO `collection` VALUES (13, '自定义定时任务', 'https://www.cnblogs.com/likun10579/p/10896831.html', 9, '自定义定时任务，从数据库读取定时任务的参数来决定何时执行定时任务', '2021-08-16 15:00:34', NULL);
INSERT INTO `collection` VALUES (14, 'BootCDN', 'https://www.bootcdn.cn/', 1, '前端资源文件，如：vue.js，jquery.js ...CDN整合，稳定、快速、免费的前端开源项目 CDN 加速服务', '2021-08-16 16:48:58', NULL);
INSERT INTO `collection` VALUES (15, 'Vue', 'https://cn.vuejs.org/', 1, 'Vue官网', '2021-08-17 14:29:19', NULL);

SET FOREIGN_KEY_CHECKS = 1;
