package com.xiaoyu.utils;

import com.xiaoyu.web.connect.bean.ColumnInfo;
import com.xiaoyu.web.connect.bean.DBConfig;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库工具类, TODO 目前只支持Mysql
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:34
 */
public class DBUtil {
    public static final String MYSQL_DRIVER_OLD = "com.mysql.jdbc.Driver"; // 老版本
    public static final String MYSQL_DRIVER_NEW = "com.mysql.cj.jdbc.Driver"; // 新版本
    public static final String MYSQL_URL_prefix = "jdbc:mysql://"; // 前缀
    public static final String MYSQL_URL_suffix = "?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai"; // 后缀

    /**
     * 创建连接串
     *
     * @param dBConfig 数据库配置
     * @return 连接串
     */
    public static String getConnUrl(DBConfig dBConfig) {
        // switch (dBConfig.getType()) {
        //     case "mysql":
        //     default:
        return MYSQL_URL_prefix + dBConfig.getHost() + ":" + dBConfig.getPort() + "/" + dBConfig.getDbName() + MYSQL_URL_suffix;
        // }
    }

    /**
     * 获取数据库中所有的表名
     *
     * @param dbConfig 数据源配置
     * @return 表名 List
     */
    public static List<String> getTableNamesByDBName(DBConfig dbConfig) {
        List<String> tableNames = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        String sql = "select TABLE_NAME from information_schema.TABLES  where TABLE_SCHEMA = '" + dbConfig.getDbName() + "'";
        try {
            // 1 .加载驱动程序
            Class.forName(dbConfig.getDriver());
            // 2. 获得数据库链接
            conn = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUsername(), dbConfig.getPassword());
            // 3. 通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            stat = conn.createStatement();
            // 4. 执行sql
            rs = stat.executeQuery(sql);
            // 5. 遍历
            while (rs.next()) {
                tableNames.add(rs.getString("TABLE_NAME"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return tableNames;
    }

    /**
     * 获取指定表的字段信息
     *
     * @param dbConfig  数据源配置
     * @param tableName 表名
     * @return 字段信息 List
     */
    public static List<ColumnInfo> getFieldInfoFromTable(DBConfig dbConfig, String tableName) {
        String sql = "show full columns from " + tableName;
        List<ColumnInfo> columnInfos = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        try {
            // 1 .加载驱动程序
            Class.forName(dbConfig.getDriver());
            // 2. 获得数据库链接
            conn = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUsername(), dbConfig.getPassword());
            // 3. 通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            stat = conn.createStatement();
            // 4. 执行sql
            rs = stat.executeQuery(sql);
            // 5. 遍历
            while (rs.next()) {
                ColumnInfo columnInfo = new ColumnInfo();
                columnInfo.setField(rs.getString("Field"));
                columnInfo.setType(rs.getString("Type"));
                columnInfo.setKey(StringUtils.isNotBlank(rs.getString("Key")));
                columnInfo.setNull("NO".equalsIgnoreCase(rs.getString("Null")));
                columnInfo.setAutoIncrement((StringUtils.isNotBlank(rs.getString("Extra")) && rs.getString("Extra").contentEquals("auto_increment")));
                columnInfo.setComment(rs.getString("Comment"));
                columnInfos.add(columnInfo);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return columnInfos;
    }

}
