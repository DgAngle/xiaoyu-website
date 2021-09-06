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

 Date: 06/09/2021 18:08:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `noteId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `noteName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '笔记名称',
  `noteCatId` bigint(20) NULL DEFAULT NULL COMMENT '笔记分类主键',
  `LabelIdArr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '笔记标签',
  `noteContent` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '笔记内容',
  `level` int(11) NULL DEFAULT NULL COMMENT '重要等级1-7',
  `isTop` int(11) NULL DEFAULT NULL COMMENT '是否置顶',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`noteId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (1, 'apache-poi 直接解析本地Excel', 1, NULL, '// Java 读写 excel\nhttps://zhuanlan.zhihu.com/p/74922498\n\n// 省市对照表 2020版\nhttps://www.b910.cn/tool/1.htm', 0, 0, '2021-09-06 10:28:48', NULL);
INSERT INTO `note` VALUES (2, 'Maven安装三方Jar包到本地仓库', 1, NULL, '// 需要配置Maven本地环境变量\nmvn install:install-file \n    -DgroupId=Msc // groupId\n    -DartifactId=Msc // artifactId\n    -Dversion=1.0 // version\n    -Dpackaging=jar // jar\n    -Dfile=Msc.jar  // 文件名\n\n// 示例, 首先定位到 Msc.jar 所在目录, 再执行下面的命令\nmvn install:install-file -DgroupId=Msc -DartifactId=Msc -Dversion=1.0 -Dpackaging=jar -Dfile=Msc.jar ', 0, 0, '2021-09-06 10:32:11', NULL);
INSERT INTO `note` VALUES (3, '硬件接口对接', 2, NULL, NULL, 0, 0, '2021-09-06 10:33:52', NULL);
INSERT INTO `note` VALUES (4, '既许一人以偏爱，愿尽余生之慷慨', 7, NULL, '既许一人以偏爱，愿尽余生之慷慨【爱情】', 0, 0, '2021-09-06 11:00:25', NULL);
INSERT INTO `note` VALUES (5, 'Git提交报错', 8, NULL, '报错：OpenSSL SSL_read: Connection was reset, errno 10054\n解决：https://blog.csdn.net/weixin_43945983/article/details/110882074', 0, 0, '2021-09-06 11:13:18', NULL);

SET FOREIGN_KEY_CHECKS = 1;
