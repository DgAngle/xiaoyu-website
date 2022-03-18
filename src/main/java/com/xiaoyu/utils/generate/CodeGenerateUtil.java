package com.xiaoyu.utils.generate;

import com.xiaoyu.utils.DBUtil;
import com.xiaoyu.utils.DateUtil;
import com.xiaoyu.utils.FileUtil;
import com.xiaoyu.web.connect.bean.ColumnInfo;
import com.xiaoyu.web.connect.bean.DBConfig;
import com.xiaoyu.web.connect.bean.TableInfo;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * 基于 Freemarker 的代码生成器
 * 参考 https://www.cnblogs.com/kelelipeng/p/10138351.html
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/14 15:25
 */
public class CodeGenerateUtil {
    private static Logger logger = LoggerFactory.getLogger(CodeGenerateUtil.class); // 日志

    private static final String encoding = "utf-8"; // 文件编码
    private static final String author = "gqshuang"; // 作者
    private static final String currentDate = DateUtil.dateToString(new Date(), "yyyy/MM/dd HH:mm"); // 文件生成时间
    private static final String packageName = "com.xiaoyu.web"; // 包路径
    private static final String diskPath = "D://GenerateCode//"; // 本地磁盘(存储)路径

    // 生成代码 - 整个数据库
    public static void generateCode(DBConfig dbConfig) {
        logger.info("生成代码 Begin");
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("author", author);
        dataMap.put("date", currentDate);
        dataMap.put("packageName", packageName);
        List<TableInfo> tableInfos = getTableInfo(dbConfig); // 获取表和对应属性信息
        Optional.ofNullable(tableInfos).orElse(new ArrayList<>()).forEach(tableInfo -> {
            // 后端代码生成
            generateBean(tableInfo, dataMap); // 生成Bean
            generateController(tableInfo, dataMap); // 生成Controller
            generateService(tableInfo, dataMap); // 生成Service
            generateMapper(tableInfo, dataMap); // 生成Mapper
            // 前端页面生成
            generateHtmlList(tableInfo, dataMap); // 生成Html->List前端页面
            generateHtmlModal(tableInfo, dataMap); // 生成Html->Modal前端页面
        });
        logger.info("生成代码 End");
    }

    // 生成代码 - 单张表
    public static void generateCode(DBConfig dbConfig, String tableName) {
        logger.info("Begin 生成代码, 表->{}", tableName);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("author", author);
        dataMap.put("date", currentDate);
        dataMap.put("packageName", packageName);
        TableInfo tableInfo = getTableInfo(dbConfig, tableName); // 获取表和对应属性信息
        // 后端代码生成
        generateBean(tableInfo, dataMap); // 生成Bean
        generateController(tableInfo, dataMap); // 生成Controller
        generateService(tableInfo, dataMap); // 生成Service
        generateMapper(tableInfo, dataMap); // 生成Mapper
        // 前端页面生成
        generateHtmlList(tableInfo, dataMap); // 生成Html->List前端页面
        generateHtmlModal(tableInfo, dataMap); // 生成Html->Modal前端页面
        logger.info("End 生成代码, 表->{}", tableName);
    }

    // 获取表和对应属性信息
    private static List<TableInfo> getTableInfo(DBConfig dbConfig) {
        List<TableInfo> tableInfos = DBUtil.getTableInfos(dbConfig);
        Optional.ofNullable(tableInfos).orElse(new ArrayList<>()).forEach(tableInfo -> {
            List<ColumnInfo> columnInfos = DBUtil.getColumnInfosFromTable(dbConfig, tableInfo.getTableName());
            tableInfo.setColumns(columnInfos);
            tableInfo.setInsertSql(createInsertSQL(columnInfos, tableInfo.getTableName()));
            tableInfo.setDeleteByIdSql(createDeleteByIdSQL(columnInfos, tableInfo.getTableName()));
            tableInfo.setSelectByIdSql(createSelectByIdSQL(columnInfos, tableInfo.getTableName()));
        });
        return tableInfos;
    }

    // 获取表和对应属性信息
    private static TableInfo getTableInfo(DBConfig dbConfig, String tableName) {
        TableInfo tableInfo = DBUtil.getTableInfo(dbConfig, tableName);
        List<ColumnInfo> columnInfos = DBUtil.getColumnInfosFromTable(dbConfig, tableInfo.getTableName());
        tableInfo.setColumns(columnInfos);
        tableInfo.setInsertSql(createInsertSQL(columnInfos, tableInfo.getTableName()));
        tableInfo.setDeleteByIdSql(createDeleteByIdSQL(columnInfos, tableInfo.getTableName()));
        tableInfo.setSelectByIdSql(createSelectByIdSQL(columnInfos, tableInfo.getTableName()));
        return tableInfo;
    }

    // 根据主键删除SQL
    private static String createDeleteByIdSQL(List<ColumnInfo> columnInfos, String tableName) {
        StringBuilder sql = new StringBuilder();
        StringBuilder column = new StringBuilder(); // 列名
        sql.append("delete from ");
        sql.append(tableName);
        if (columnInfos != null) {
            for (ColumnInfo columnInfo : columnInfos) {
                if (columnInfo.isPrimaryKey()) {
                    sql.append(" where " + columnInfo.getColumnName() + "Id=#{" + columnInfo.getColumnName() + "Id}");
                    break;
                }
            }
        }
        // sql.append(" where " + tableName + "Id=#{" + tableName + "Id}"); // 主键查询条件
        // sql.append(" where id=#{id}"); // 主键查询条件
        logger.info("删除SQL：{}", sql.toString());
        return sql.toString();
    }

    // 根据主键查询SQL
    private static String createSelectByIdSQL(List<ColumnInfo> columnInfos, String tableName) {
        StringBuilder sql = new StringBuilder();
        StringBuilder wherePrimaryKey = new StringBuilder();
        StringBuilder column = new StringBuilder(); // 列名
        sql.append("select ");
        Optional.ofNullable(columnInfos).orElse(new ArrayList<>()).forEach(columnInfo -> {
            column.append(columnInfo.getColumnName() + ",");
            if (columnInfo.isPrimaryKey()) wherePrimaryKey.append(" where " + columnInfo.getColumnName() + "Id=#{" + columnInfo.getColumnName() + "Id}");
        });
        sql.append(column.substring(0, column.length() - 1));
        sql.append(" from ");
        sql.append(tableName);
        sql.append(wherePrimaryKey); // 主键查询条件
        // sql.append(" where " + tableName + "Id=#{" + tableName + "Id}"); // 主键查询条件
        // sql.append(" where id=#{id}"); // 主键查询条件
        logger.info("查询SQL：{}", sql.toString());
        return sql.toString();
    }

    // 插入SQL
    private static String createInsertSQL(List<ColumnInfo> columnInfos, String tableName) {
        StringBuilder sql = new StringBuilder();
        StringBuilder column = new StringBuilder(); // 列名
        StringBuilder value = new StringBuilder(); // 对应的值
        sql.append("insert into ");
        sql.append(tableName);
        sql.append("(");
        Optional.ofNullable(columnInfos).orElse(new ArrayList<>()).forEach(columnInfo -> {
            column.append(columnInfo.getColumnName() + ",");
            value.append("#{" + columnInfo.getColumnName() + "},");
        });
        sql.append(column.substring(0, column.length() - 1));
        sql.append(")");
        sql.append(" values(");
        sql.append(value.substring(0, value.length() - 1));
        sql.append(")");
        logger.info("插入SQL：{}", sql.toString());
        return sql.toString();
    }

    // 生成Bean
    public static void generateBean(TableInfo tableInfo, Map<String, Object> dataMap) {
        logger.info("生成Bean");
        final String suffix = ".java";
        final String savePath = diskPath + tableInfo.getClassLowercaseName() + "/" + tableInfo.getClassUppercaseName() + suffix;
        generate(tableInfo, dataMap, savePath, FreemarkerUtil.templateBean);
    }

    // 生成Controller
    public static void generateController(TableInfo tableInfo, Map<String, Object> dataMap) {
        logger.info("生成Controller");
        final String suffix = ".java";
        final String savePath = diskPath + tableInfo.getClassLowercaseName() + "/" + tableInfo.getClassUppercaseName() + "Controller" + suffix;
        generate(tableInfo, dataMap, savePath, FreemarkerUtil.templateController);
    }

    // 生成Service
    public static void generateService(TableInfo tableInfo, Map<String, Object> dataMap) {
        logger.info("生成Service");
        final String suffix = ".java";
        final String savePath = diskPath + tableInfo.getClassLowercaseName() + "/" + tableInfo.getClassUppercaseName() + "Service" + suffix;
        generate(tableInfo, dataMap, savePath, FreemarkerUtil.templateService);
    }

    // 生成Mapper
    public static void generateMapper(TableInfo tableInfo, Map<String, Object> dataMap) {
        logger.info("生成Mapper");
        final String suffix = ".java";
        final String savePath = diskPath + tableInfo.getClassLowercaseName() + "/" + tableInfo.getClassUppercaseName() + "Mapper" + suffix;
        generate(tableInfo, dataMap, savePath, FreemarkerUtil.templateMapper);
    }

    // 生成前端Html->List页面
    private static void generateHtmlList(TableInfo tableInfo, Map<String, Object> dataMap) {
        logger.info("生成Html->List");
        final String suffix = ".html";
        final String savePath = diskPath + tableInfo.getClassLowercaseName() + "/" + tableInfo.getClassLowercaseName() + "List" + suffix;
        generate(tableInfo, dataMap, savePath, FreemarkerUtil.templateHtmlList);
    }

    // 生成前端Html->Modal页面
    private static void generateHtmlModal(TableInfo tableInfo, Map<String, Object> dataMap) {
        logger.info("生成Html->Modal");
        final String suffix = ".html";
        final String savePath = diskPath + tableInfo.getClassLowercaseName() + "/" + tableInfo.getClassLowercaseName() + "Modal" + suffix;
        generate(tableInfo, dataMap, savePath, FreemarkerUtil.templateHtmlModal);
    }

    /**
     * 生成代码 - 最终调用方法
     *
     * @param tableInfo    包信息及作者信息
     * @param dataMap      模板数据
     * @param savePath     保存地址
     * @param templateName 模板名称
     */
    private static void generate(TableInfo tableInfo, Map<String, Object> dataMap, String savePath, String templateName) {
        File file = FileUtil.createFile(savePath);
        Template template = null;
        FileOutputStream fos = null;
        try {
            template = FreemarkerUtil.getTemplate(templateName);
            fos = new FileOutputStream(file);
            dataMap.put("tableInfo", tableInfo);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, encoding), 10240);
            template.process(dataMap, out);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            logger.info("IO操作异常", ioException);
        } catch (TemplateException e) {
            logger.info("模板解析异常", e);
        }
    }

    public static void main(String[] args) throws Exception {
        // DBConfig dbConfig = new DBConfig();
        // String driver = "com.mysql.jdbc.Driver";
        // String url = "jdbc:mysql://localhost:3306/xiaoyu_website?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        // String username = "root";
        // String password = "root";
        // dbConfig.setUrl(url);
        // dbConfig.setDriver(driver);
        // dbConfig.setUsername(username);
        // dbConfig.setPassword(password);
        // dbConfig.setDbName("xiaoyu_website");
        // CodeGenerateUtil.generateCode(dbConfig, "db_config");
    }

}
