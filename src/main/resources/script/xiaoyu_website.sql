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

 Date: 26/07/2021 22:34:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
                          `labelId` bigint(20) NOT NULL COMMENT '主键',
                          `labelName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签名称',
                          `useCount` int(11) NULL DEFAULT NULL COMMENT '使用数量',
                          `labelType` int(11) NULL DEFAULT NULL COMMENT '标签类型, note/music/...',
                          `nameSymbol` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签首字母拼音符号, 用于按照字母分类查找标签',
                          `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
                          `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
                          `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                          PRIMARY KEY (`labelId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of label
-- ----------------------------

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
                         `noteId` bigint(20) NOT NULL COMMENT '主键',
                         `noteName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '笔记名称',
                         `noteCat` bigint(20) NULL DEFAULT NULL COMMENT '笔记分类',
                         `LabelIdArr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '笔记标签',
                         `noteContent` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '笔记内容',
                         `level` int(11) NULL DEFAULT NULL COMMENT '重要等级1-7',
                         `isTop` int(11) NULL DEFAULT NULL COMMENT '是否置顶',
                         `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
                         `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                         PRIMARY KEY (`noteId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------

-- ----------------------------
-- Table structure for note_cat
-- ----------------------------
DROP TABLE IF EXISTS `note_cat`;
CREATE TABLE `note_cat`  (
                             `noteCatId` bigint(20) NOT NULL COMMENT '主键',
                             `noteCatName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
                             `noteCatNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '笔记分类编号,四位一级,例：000100010001',
                             `parentNoteCatId` bigint(20) NULL DEFAULT NULL COMMENT '父级主键',
                             `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
                             `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
                             `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                             PRIMARY KEY (`noteCatId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note_cat
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                         `roleId` bigint(20) NOT NULL COMMENT '主键',
                         `roleName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
                         `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
                         `createDt` datetime NULL DEFAULT NULL COMMENT '创建日期',
                         `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                         PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
                         `typeId` bigint(20) NOT NULL COMMENT '主键',
                         `typeName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
                         `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
                         `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
                         `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                         PRIMARY KEY (`typeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `userId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户ID',
                         `realname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
                         `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
                         `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                         `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别：0：女, 1：男',
                         `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                         `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机',
                         `identify` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证',
                         `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                         PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('212e9d78-e2cc-11eb-ac37-002324c5600f', '系统管理员', 'admin', '123456', '1', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
