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

 Date: 09/09/2021 19:25:40
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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (1, 'apache-poi 直接解析本地Excel', 1, NULL, '// Java 读写 excel\nhttps://zhuanlan.zhihu.com/p/74922498\n\n// 省市对照表 2020版\nhttps://www.b910.cn/tool/1.htm', 0, 0, '2021-09-06 10:28:48', NULL);
INSERT INTO `note` VALUES (2, 'Maven安装三方Jar包到本地仓库', 1, NULL, '// 需要配置Maven本地环境变量\nmvn install:install-file \n    -DgroupId=Msc // groupId\n    -DartifactId=Msc // artifactId\n    -Dversion=1.0 // version\n    -Dpackaging=jar // jar\n    -Dfile=Msc.jar  // 文件名\n\n// 示例, 首先定位到 Msc.jar 所在目录, 再执行下面的命令\nmvn install:install-file -DgroupId=Msc -DartifactId=Msc -Dversion=1.0 -Dpackaging=jar -Dfile=Msc.jar ', 0, 0, '2021-09-06 10:32:11', NULL);
INSERT INTO `note` VALUES (3, '访客机硬件接口对接', 2, NULL, '标题：对接大数据访客信息', 0, 0, '2021-09-06 10:33:52', NULL);
INSERT INTO `note` VALUES (4, '既许一人以偏爱，愿尽余生之慷慨', 7, NULL, '既许一人以偏爱，愿尽余生之慷慨【爱情】', 0, 0, '2021-09-06 11:00:25', NULL);
INSERT INTO `note` VALUES (5, 'Git提交报错', 8, NULL, '报错：OpenSSL SSL_read: Connection was reset, errno 10054\n解决：https://blog.csdn.net/weixin_43945983/article/details/110882074', 0, 0, '2021-09-06 11:13:18', NULL);
INSERT INTO `note` VALUES (6, 'Post请求之 java.net', 1, NULL, '    /**\n     * 向指定 URL 发送POST方法的请求\n     *\n     * @param url   发送请求的 URL\n     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。\n     * @return 所代表远程资源的响应结果\n     */\n    public static String sendPost(String url, JSONObject param) {\n        PrintWriter out = null;\n        BufferedReader in = null;\n        String result = \"\";\n        try {\n            URL realUrl = new URL(url);\n            // 打开和URL之间的连接\n            URLConnection conn = realUrl.openConnection();\n            // 设置通用的请求属性\n            conn.setRequestProperty(\"accept\", \"*/*\");\n            conn.setRequestProperty(\"connection\", \"Keep-Alive\");\n            conn.setRequestProperty(\"user-agent\", \"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)\");\n            // 发送POST请求必须设置如下两行\n            conn.setDoOutput(true);\n            conn.setDoInput(true);\n            // 获取URLConnection对象对应的输出流\n            out = new PrintWriter(conn.getOutputStream());\n            // 发送请求参数\n            out.print(param);\n            // flush输出流的缓冲\n            out.flush();\n            // 定义BufferedReader输入流来读取URL的响应\n            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));\n            String line;\n            while ((line = in.readLine()) != null) {\n                result += line;\n            }\n        } catch (Exception e) {\n            System.out.println(\"发送 POST 请求出现异常！\" + e);\n            e.printStackTrace();\n        }\n        // 使用finally块来关闭输出流、输入流\n        finally {\n            try {\n                if (out != null) {\n                    out.close();\n\n                }\n                if (in != null) {\n                    in.close();\n                }\n            } catch (IOException ex) {\n                ex.printStackTrace();\n            }\n        }\n        return result;\n    }', 0, 0, '2021-09-08 11:00:39', NULL);
INSERT INTO `note` VALUES (7, 'Post请求之 Apache', 1, NULL, '/**\n     * 发送post请求\n     *\n     * @param url      路径\n     * @param params   参数(json类型)\n     * @param encoding 编码格式\n     * @return 响应报文\n     */\n    public static String sendPost(String url, JSONObject params, String encoding) {\n        String body = \"\";\n\n        //创建httpclient对象\n        CloseableHttpClient client = HttpClients.createDefault();\n        //创建post方式请求对象\n        HttpPost httpPost = new HttpPost(url);\n\n        //装填参数\n        StringEntity s = new StringEntity(params.toString(), \"utf-8\");\n        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, \"application/json\"));\n        //设置参数到请求对象中\n        httpPost.setEntity(s);\n        // System.out.println(\"请求地址：\" + url);\n        // System.out.println(\"请求参数：\"+ nvps.toString());\n\n        // 设置header信息\n        // 指定报文头【Content-type】、【User-Agent】\n        // httpPost.setHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n        httpPost.setHeader(\"Content-type\", \"application/json\");\n        httpPost.setHeader(\"User-Agent\", \"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)\");\n\n        //执行请求操作，并拿到结果（同步阻塞）\n        CloseableHttpResponse response = null;\n        try {\n            response = client.execute(httpPost);\n            //获取结果实体\n            HttpEntity entity = response.getEntity();\n            if (entity != null) {\n                //按指定编码转换结果实体为String类型\n                body = EntityUtils.toString(entity, encoding);\n            }\n            EntityUtils.consume(entity);\n        } catch (IOException e) {\n            e.printStackTrace();\n        } finally {\n            //释放链接\n            try {\n                response.close();\n            } catch (IOException e) {\n                e.printStackTrace();\n            }\n        }\n        return body;\n    }', 0, 0, '2021-09-08 11:02:18', NULL);
INSERT INTO `note` VALUES (8, 'HahsMap源码', 5, NULL, NULL, 0, 0, '2021-09-09 13:50:46', NULL);
INSERT INTO `note` VALUES (9, '日期格式化', 5, NULL, '```javascript\n// 方法\nfunction dateFormat(fmt, date) {\n    let ret;\n    const opt = {\n        \"Y+\": date.getFullYear().toString(),        // 年\n        \"m+\": (date.getMonth() + 1).toString(),     // 月\n        \"d+\": date.getDate().toString(),            // 日\n        \"H+\": date.getHours().toString(),           // 时\n        \"M+\": date.getMinutes().toString(),         // 分\n        \"S+\": date.getSeconds().toString()          // 秒\n        // 有其他格式化字符需求可以继续添加，必须转化成字符串\n    };\n    for (let k in opt) {\n        ret = new RegExp(\"(\" + k + \")\").exec(fmt);\n        if (ret) {\n            fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, \"0\")))\n        }\n    }\n    return fmt;\n}\n\n// 调用 YYYY-mm-dd HH:MM:SS\nconsole.log(dateFormat(\"YYYY-mm-dd 23:59:59\", new Date()));\n```', 0, 0, '2021-09-09 19:12:37', NULL);
INSERT INTO `note` VALUES (10, '自定义搜索下拉', 5, NULL, '```html\n// 标签, 这里使用了 Vue.js\n<div class=\"col-sm-3\" id=\"contextCompanyBox\">\n    <input name=\"companyName\" type=\"text\" value=\"\" class=\"form-control form-control-sm\" placeholder=\"企业名称\" data-content=\"企业名称\" autocomplete=\"off\"\n           v-model:value=\"configBean.companyName\" @input.stop=\"jobfair.companyNameChanged();\" @click=\"jobfair.companyNameCLick();\"/>\n    <ul class=\"dropdown-menu shadow-sm tal-dropdown-scroll\" @hover=\"jobfair.companyNameBlur();\"\n        style=\"margin-left: 14px; width: 90%; height: auto; max-height: 200px;\"\n        aria-labelledby=\"dropdownMenu\" id=\"companyDropdown\">\n        <li class=\"tal-dropdown-item\" v-for=\"company in configBean.companyDropList\" @click=\"jobfair.selectAddCompay(company.id,company.companyName);\">\n            {{company.companyName}}\n        </li>\n    </ul>\n</div>\n\n```\n```css\n// 样式\n.tal-dropdown-scroll {\n    display: block;\n    z-index: 999;\n    background: #fff;\n    border: 1px solid #ccc;\n    padding: 2px;\n    width: 180px;\n    height: 100px;\n    overflow-x: hidden;\n    overflow-y: scroll;\n}\n```\n```javascript\n// 监听，除了点击自己，点击其他地方将自身隐藏\ndocument.addEventListener(\"click\", e => {\n    const contextCompanyBox = document.getElementById(\"contextCompanyBox\");\n    if (contextCompanyBox) {\n        if (!contextCompanyBox.contains(e.target)) {\n            this.rightFlag = false;\n            $(\"#companyDropdown\").hide();\n        }\n    }\n});\n```', 0, 0, '2021-09-09 19:17:08', NULL);

SET FOREIGN_KEY_CHECKS = 1;
