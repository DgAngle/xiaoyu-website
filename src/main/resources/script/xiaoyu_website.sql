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

 Date: 03/09/2021 18:28:05
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
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (1, 'RedSpider社区', 'http://concurrent.redspider.group/RedSpider.html', 4, '多线程相关内容', '2021-08-16 10:14:35', '');
INSERT INTO `collection` VALUES (2, '凤凰架构', 'https://icyfenix.cn/', 4, '如何构建可靠的大型分布式系统', '2021-08-16 10:40:12', NULL);
INSERT INTO `collection` VALUES (3, 'Bootstrap4', 'https://v4.bootcss.com/', 1, 'Bootstrap4官网', '2021-08-16 10:41:35', NULL);
INSERT INTO `collection` VALUES (4, 'Leetcode', 'https://leetcode-cn.com/', 3, '算法学习以及练习网站', '2021-08-16 12:48:11', NULL);
INSERT INTO `collection` VALUES (5, 'Tomcat下载', 'https://archive.apache.org/dist/tomcat/', 6, 'Tomcat历史版本下载', '2021-08-16 13:17:45', NULL);
INSERT INTO `collection` VALUES (6, 'JQuery在线中文文档', 'https://jquery.cuishifeng.cn/', 7, 'JQuery 在线Api', '2021-08-16 13:21:45', NULL);
INSERT INTO `collection` VALUES (7, 'Fontawesome-icon', 'https://fontawesome.dashgame.com/', 1, 'fontawesome字体图标官网', '2021-08-16 13:22:56', NULL);
INSERT INTO `collection` VALUES (8, 'Google翻译', 'https://translate.google.cn/', 8, 'Google 在线翻译', '2021-08-16 13:40:36', NULL);
INSERT INTO `collection` VALUES (9, '有道翻译', 'https://fanyi.youdao.com/', 8, '有道云在线翻译', '2021-08-16 13:40:58', NULL);
INSERT INTO `collection` VALUES (10, 'ProcessOn', 'https://www.processon.com/', 5, 'ProcessOn在线流程图、脑图笔记', '2021-08-16 14:14:09', NULL);
INSERT INTO `collection` VALUES (11, 'iconfont-阿里巴巴矢量图标库', 'https://www.iconfont.cn/home/index', 1, 'iconfont-阿里巴巴矢量图标库官方网站', '2021-08-16 14:30:39', NULL);
INSERT INTO `collection` VALUES (12, 'CSDN', 'https://www.csdn.net/', 1, 'CSDN-IT博客网站', '2021-08-16 14:32:47', NULL);
INSERT INTO `collection` VALUES (13, '自定义定时任务', 'https://www.cnblogs.com/likun10579/p/10896831.html', 9, '自定义定时任务，从数据库读取定时任务的参数来决定何时执行定时任务', '2021-08-16 15:00:34', NULL);
INSERT INTO `collection` VALUES (14, 'BootCDN', 'https://www.bootcdn.cn/', 1, '前端资源文件，如：vue.js，jquery.js ...CDN整合，稳定、快速、免费的前端开源项目 CDN 加速服务', '2021-08-16 16:48:58', NULL);
INSERT INTO `collection` VALUES (15, 'Vue', 'https://cn.vuejs.org/', 1, 'Vue官网', '2021-08-17 14:29:19', NULL);
INSERT INTO `collection` VALUES (16, '言曌博客', 'https://liuyanzhao.com/', 9, '知乎上对JAVA的io流和nio有什么区别的回答', '2021-08-19 08:40:41', NULL);
INSERT INTO `collection` VALUES (17, 'Axure RP9 授权码/注册码', 'http://www.axureschool.cn/164.html', 9, 'Axure 学院 > 软件相关 > 授权码 > Axure RP9 授权码/注册码', '2021-08-19 08:43:32', NULL);
INSERT INTO `collection` VALUES (18, 'Tob Design B端可视化', 'https://tob.design/#/home', 1, 'B端,大屏可视化设计网站', '2021-08-19 08:45:10', NULL);
INSERT INTO `collection` VALUES (19, 'Java的IO流和NIO有什么区别？', 'https://www.zhihu.com/question/337609338/answer/1911778761', 9, '知乎上对 Java 的 IO 流和 NIO 有什么区别的回答', '2021-08-19 09:26:43', NULL);
INSERT INTO `collection` VALUES (20, 'Bootstrap插件库', 'http://www.bootstrapmb.com/', 1, 'Bootstrap模板库', '2021-08-19 14:37:07', NULL);
INSERT INTO `collection` VALUES (21, 'Vue垂直时间线', 'http://www.bootstrapmb.com/item/6912', 10, 'Vue垂直时间线代码特效', '2021-08-19 15:05:14', NULL);
INSERT INTO `collection` VALUES (22, 'Vue图片3D倾斜特效', 'http://www.bootstrapmb.com/item/6758', 10, 'Vue图片3D倾斜特效', '2021-08-19 15:06:27', NULL);
INSERT INTO `collection` VALUES (23, 'Vue 背景渐变颜色生成器', 'http://www.bootstrapmb.com/item/4721', 10, 'Vue 背景渐变颜色生成器', '2021-08-19 15:07:06', NULL);
INSERT INTO `collection` VALUES (24, 'CSS3倾斜样式文字卡片列表', 'http://www.bootstrapmb.com/item/10822', 10, 'CSS3倾斜样式文字卡片列表特效', '2021-08-19 15:07:56', NULL);
INSERT INTO `collection` VALUES (25, '可关闭的tab选项卡插件', 'http://www.bootstrapmb.com/item/10961', 10, 'Bootstrap 可关闭的tab选项卡插件', '2021-08-19 15:08:28', NULL);
INSERT INTO `collection` VALUES (26, 'Vue银行卡叠加样式tab切换', 'http://www.bootstrapmb.com/item/8365', 10, 'Vue银行卡叠加样式tab切换', '2021-08-19 15:11:27', NULL);
INSERT INTO `collection` VALUES (27, '可视化拖拽表单设计器JS插件', 'http://www.bootstrapmb.com/item/9992', 10, '可视化拖拽表单设计器js插件', '2021-08-19 15:12:08', NULL);
INSERT INTO `collection` VALUES (28, 'Css3+Js玻璃样式卡片网格样式', 'http://www.bootstrapmb.com/item/9775', 10, 'css3+js玻璃样式卡片网格样式', '2021-08-19 15:16:16', NULL);
INSERT INTO `collection` VALUES (29, 'JQuery和CSS3悬浮模糊效果插件', 'http://www.bootstrapmb.com/item/1387', 10, 'JQuery和CSS3悬浮模糊效果插件', '2021-08-19 15:20:52', NULL);
INSERT INTO `collection` VALUES (30, 'Message.js消息提示层插件', 'http://www.bootstrapmb.com/item/9337', 10, 'Message.js消息提示层插件', '2021-08-19 15:27:14', NULL);
INSERT INTO `collection` VALUES (31, '成功警告提示层js插件自动关闭', 'http://www.bootstrapmb.com/item/10276', 10, '成功警告提示层Js插件自动关闭', '2021-08-19 15:29:29', NULL);
INSERT INTO `collection` VALUES (32, 'JQuery消息提示弹窗插件VtMessage.js', 'http://www.bootstrapmb.com/item/8790', 10, 'jquery消息提示弹窗插件VtMessage.js', '2021-08-19 15:29:53', NULL);
INSERT INTO `collection` VALUES (33, 'Loading&预警提示层Js插件', 'http://www.bootstrapmb.com/item/10817', 10, 'Loading&预警提示层js插件', '2021-08-19 15:34:56', NULL);
INSERT INTO `collection` VALUES (34, 'Vue可爱动物卡片样式动画特效', 'http://www.bootstrapmb.com/item/10801', 10, 'Vue可爱动物卡片样式动画特效', '2021-08-19 16:10:52', NULL);
INSERT INTO `collection` VALUES (35, 'Jquery插件库', 'https://www.jq22.com/', 1, 'Jquery插件', '2021-08-19 16:41:11', NULL);
INSERT INTO `collection` VALUES (36, 'JS消息提示插件Message.js', 'https://www.jq22.com/jquery-info23550', 10, '原生JS消息提示插件Message.js(原创)', '2021-08-19 16:56:33', NULL);
INSERT INTO `collection` VALUES (37, '新拟物化登陆UI设计', 'https://www.jq22.com/demo/cssnwhdl202101040928/', 10, '新拟物化登陆UI设计\nhttps://www.jq22.com/jquery-info23579', '2021-08-19 17:02:06', NULL);
INSERT INTO `collection` VALUES (38, 'labuladong的算法小抄', 'https://labuladong.gitbook.io/algo/', 4, '算法在线读，leetcode刷题', '2021-08-20 09:55:32', NULL);
INSERT INTO `collection` VALUES (39, 'CSS阴影效果(Box-shadow)用法趣味讲解', 'https://www.webhek.com/post/css-box-shadow-property.html', 9, 'CSS 之 box-shadow 属性用法详解', '2021-08-24 13:41:29', NULL);
INSERT INTO `collection` VALUES (40, 'Github', 'https://github.com/', 3, 'Github官网', '2021-08-25 11:59:58', NULL);
INSERT INTO `collection` VALUES (41, 'Centos 下载', 'http://mirrors.aliyun.com/centos/', 6, '虚拟机CentOS系统 aliyun镜像下载', '2021-08-25 12:02:10', NULL);
INSERT INTO `collection` VALUES (42, 'JQuery 下载', 'https://www.jq22.com/plugin/122', 6, 'JQuery 历史版本下载', '2021-08-25 12:03:18', NULL);
INSERT INTO `collection` VALUES (43, 'Stackoverflow', 'https://stackoverflow.com/', 3, 'Stackoverflow，程序员的在线问答网站，解决各种BUG', '2021-08-25 12:05:14', NULL);
INSERT INTO `collection` VALUES (44, 'ProcessOn', 'https://www.processon.com/', 1, 'ProcessOn官网，在线设计流程图，思维导图', '2021-08-25 12:08:31', NULL);
INSERT INTO `collection` VALUES (45, 'Fontawesome-设计师入口-icon', 'http://www.fontawesome.com.cn/icons-ui/', 1, 'Fontawesome设计师专用入口,可以进行搜索', '2021-08-30 09:43:09', NULL);
INSERT INTO `collection` VALUES (46, 'jQuery自定义日历事项查看插件', 'http://www.bootstrapmb.com/item/2855', 10, 'jQuery自定义日历事项查看插件', '2021-09-02 13:29:17', NULL);
INSERT INTO `collection` VALUES (47, 'Js单双日历插件日期范围选择 - When', 'http://www.bootstrapmb.com/item/1956', 10, 'Js单双日历插件日期范围选择 - When', '2021-09-02 13:29:54', NULL);
INSERT INTO `collection` VALUES (48, 'calendar.js简单的日期选择插件', 'http://www.bootstrapmb.com/item/2346', 10, 'calendar.js简单的日期选择插件', '2021-09-02 13:30:18', NULL);
INSERT INTO `collection` VALUES (49, 'bootstrap时间日期插件年度季度月度', 'http://www.bootstrapmb.com/item/8283', 10, 'bootstrap时间日期插件年度季度月度', '2021-09-02 13:30:48', NULL);
INSERT INTO `collection` VALUES (50, 'jquery-datePicker日期范围选择插件', 'http://www.bootstrapmb.com/item/10064', 10, 'jquery-datePicker日期范围选择插件', '2021-09-02 13:31:45', NULL);
INSERT INTO `collection` VALUES (51, '日期选择Js插件', 'http://www.bootstrapmb.com/item/10989', 10, '日期选择Js插件', '2021-09-02 13:32:02', NULL);
INSERT INTO `collection` VALUES (52, 'FullCalendar.js中文版jQuery日历插件', 'http://www.bootstrapmb.com/item/8012', 10, 'FullCalendar.js中文版jQuery日历插件', '2021-09-02 13:58:27', NULL);
INSERT INTO `collection` VALUES (53, 'jquery周日历插件带详细事件', 'http://www.bootstrapmb.com/item/5697', 10, 'jquery周日历插件带详细事件', '2021-09-02 13:58:42', NULL);
INSERT INTO `collection` VALUES (54, 'Bootstrap全屏日历拖拽事件插件', 'http://www.bootstrapmb.com/item/2664', 10, 'Bootstrap全屏日历拖拽事件插件', '2021-09-02 13:58:59', NULL);
INSERT INTO `collection` VALUES (55, '漂亮的CSS3日历插件代码', 'http://www.bootstrapmb.com/item/2494', 10, '漂亮的CSS3日历插件代码', '2021-09-02 13:59:15', NULL);
INSERT INTO `collection` VALUES (56, 'JS签到日历插件代码', 'http://www.bootstrapmb.com/item/2437', 10, 'JS签到日历插件代码', '2021-09-02 13:59:34', NULL);
INSERT INTO `collection` VALUES (57, 'jQuery多色日期日历插件 - jalendar', 'http://www.bootstrapmb.com/item/1984', 10, 'jQuery多色日期日历插件 - jalendar', '2021-09-02 13:59:48', NULL);
INSERT INTO `collection` VALUES (58, 'js全屏日历弹出详情插件tui.calendar', 'http://www.bootstrapmb.com/item/10120', 10, 'js全屏日历弹出详情插件tui.calendar', '2021-09-02 14:01:45', NULL);
INSERT INTO `collection` VALUES (59, 'jQuery全屏农历日历插件', 'http://www.bootstrapmb.com/item/1710', 10, 'FullCalendar.js中文版jQuery日历插件', '2021-09-02 14:02:34', NULL);
INSERT INTO `collection` VALUES (60, 'Flatpickr中文文档', 'https://www.flatpickr.cn/', 1, 'flatpickr，日期插件中文文档', '2021-09-02 18:32:08', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏分类表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签表' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记表' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of note_cat
-- ----------------------------

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

-- ----------------------------
-- Table structure for plan_cat
-- ----------------------------
DROP TABLE IF EXISTS `plan_cat`;
CREATE TABLE `plan_cat`  (
  `planCatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划主键',
  `planCatName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT ' 计划分类名称',
  `orderNum` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '排序号',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`planCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '计划分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_cat
-- ----------------------------
INSERT INTO `plan_cat` VALUES (1, '每日计划', 0000000008, '2021-08-19 13:30:39', NULL);
INSERT INTO `plan_cat` VALUES (2, '长期计划', 0000000000, '2021-08-19 13:30:50', NULL);
INSERT INTO `plan_cat` VALUES (3, '短期计划', 0000000000, '2021-08-19 13:30:57', NULL);
INSERT INTO `plan_cat` VALUES (4, '工作计划', 0000000010, '2021-08-26 14:38:18', NULL);
INSERT INTO `plan_cat` VALUES (5, '学习计划', 0000000006, '2021-08-26 14:59:14', NULL);

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消费表' ROW_FORMAT = Dynamic;

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

-- ----------------------------
-- Table structure for spend_cat
-- ----------------------------
DROP TABLE IF EXISTS `spend_cat`;
CREATE TABLE `spend_cat`  (
  `spendCatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消费分类主键',
  `spendCatName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消费分类名称',
  `orderNum` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `createDt` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createBy` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`spendCatId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消费分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spend_cat
-- ----------------------------
INSERT INTO `spend_cat` VALUES (1, '吃喝', 0, '2021-08-31 10:13:37', NULL);
INSERT INTO `spend_cat` VALUES (2, '游戏', 0, '2021-08-31 10:13:43', NULL);
INSERT INTO `spend_cat` VALUES (3, '出行', 0, '2021-08-31 10:13:48', NULL);
INSERT INTO `spend_cat` VALUES (4, '生活', 0, '2021-09-02 08:30:38', NULL);

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类型表' ROW_FORMAT = DYNAMIC;

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
