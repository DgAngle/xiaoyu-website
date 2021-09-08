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

 Date: 08/09/2021 17:36:55
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
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

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
INSERT INTO `collection` VALUES (61, '九层炼心详解', 'https://mp.weixin.qq.com/s/gEySMuR28JpqPobF5Xgn_A', 12, '九层炼心详解，古传道家西派最完整的修炼功法！', '2021-09-06 09:55:26', NULL);
INSERT INTO `collection` VALUES (62, 'Maven之Pom网站大全', 'https://mvnrepository.com/', 1, '包含了各种各样的pom', '2021-09-08 17:24:02', NULL);

SET FOREIGN_KEY_CHECKS = 1;
