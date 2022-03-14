package com.xiaoyu.utils.generate;

import com.xiaoyu.web.connect.bean.DBConfig;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于 Freemarker 的代码生成器
 * 参考 https://www.cnblogs.com/kelelipeng/p/10138351.html
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/14 15:25
 */
public class CodeGenerateUtil {

    private static final String AUTHOR = "Ay";
    private static final String CURRENT_DATE = "2017/05/03";
    private static final String tableName = "tm_project_quality_problem";
    private static final String packageName = "com.evada.pm.process.manage";
    private static final String tableAnnotation = "质量问题";
    private static final String URL = "jdbc:postgresql://192.168.3.160:10655/cibpm";
    private static final String USER = "postgres";
    private static final String PASSWORD = "888888";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String diskPath = "D://";
    private static final String changeTableName = replaceUnderLineAndUpperCase(tableName);

    // 获取连接
    public static Connection getConnection(DBConfig dbConfig) {

        Connection connection = null;
        try {
            Class.forName(dbConfig.getDriver());
            connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUsername(), dbConfig.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    // 生成代码
    public static void generateCode() {
        DBConfig dbConfig = new DBConfig();
        dbConfig.setUrl("");
        dbConfig.setDriver("");
        dbConfig.setUsername("");
        dbConfig.setPassword("");
        dbConfig.setDbName("");
        Connection connection = getConnection(dbConfig);
        DatabaseMetaData databaseMetaData = null;
        ResultSet resultSet = null;
        try {
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getColumns(null, "%", dbConfig.getDbName(), "%");

            generateBean(resultSet); // 生成实体类
            // generateController(resultSet);
            // generateService(resultSet);
            // generateMapper(resultSet);

            // //生成Mapper文件
            // generateMapperFile(resultSet);
            // //生成Dao文件
            // generateDaoFile(resultSet);
            // //生成Repository文件
            // generateRepositoryFile(resultSet);
            // //生成服务层接口文件
            // generateServiceInterfaceFile(resultSet);
            // //生成服务实现层文件
            // generateServiceImplFile(resultSet);
            // //生成Controller层文件
            // generateControllerFile(resultSet);
            // //生成DTO文件
            // generateDTOFile(resultSet);
            // //生成Model文件
            // generateModelFile(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 生成Bean
    private static void generateBean(ResultSet resultSet) throws Exception {
        final String suffix = ".java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "model-lombok.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        while (resultSet.next()) {
            //id字段略过
            if (resultSet.getString("COLUMN_NAME").equals("id")) continue;
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnClassList);
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }

    // 生成Controller
    private static void generateController(ResultSet resultSet) {

    }

    // 生成Service
    private static void generateService(ResultSet resultSet) {

    }

    // 生成Mapper
    private static void generateMapper(ResultSet resultSet) {

    }

    // 将下划线变成大写字母
    public static String replaceUnderLineAndUpperCase(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return StringUtils.capitalize(result);
    }

    private static void generateControllerFile(ResultSet resultSet) throws Exception {
        final String suffix = "Controller.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private static void generateFileByTemplate(final String templateName, File file, Map<String, Object> dataMap) throws Exception {
        Template template = FreemarkerUtil.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small", tableName);
        dataMap.put("table_name", changeTableName);
        dataMap.put("author", AUTHOR);
        dataMap.put("date", CURRENT_DATE);
        dataMap.put("package_name", packageName);
        dataMap.put("table_annotation", tableAnnotation);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }

}
