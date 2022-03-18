package com.xiaoyu.utils;

import com.xiaoyu.web.connect.bean.ColumnInfo;
import com.xiaoyu.web.connect.bean.DBConfig;
import com.xiaoyu.web.connect.bean.TableInfo;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
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
     * 获取连接
     *
     * @param dbConfig 数据源配置
     */
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
    public static List<String> getTableNames(DBConfig dbConfig) {
        List<String> tableNames = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        // 查询数据库所有的表名
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
     * 获取数据库所有表的基本信息
     *
     * @param dbConfig 数据源配置
     * @return 表名 List
     */
    public static TableInfo getTableInfo(DBConfig dbConfig, String tableNames) {
        if (StringUtils.isBlank(tableNames)) return null;
        TableInfo tableInfo = new TableInfo();
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        // 查询数据库所有表的基本信息
        String sql = "select table_name as tableName, table_comment as tableComment, engine as engine, create_time as createTime from information_schema.tables where table_schema = '" + dbConfig.getDbName() + "' and table_name='" + tableNames + "'";
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
                // TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(rs.getString("tableName"));
                tableInfo.setTableComment(rs.getString("tableComment"));
                tableInfo.setEngine(rs.getString("engine"));
                // 将下划线变成大写字母
                String upperCaseStr = replaceUnderLineAndUpperCase(tableInfo.getTableName());
                tableInfo.setClassLowercaseName(StringUtils.uncapitalize(upperCaseStr)); // 首字母小写
                tableInfo.setClassUppercaseName(StringUtils.capitalize(upperCaseStr)); // 首字母大写
                if (StringUtils.isNotBlank(rs.getString("createTime"))) tableInfo.setCreateTime(rs.getDate("createTime"));
                // tableInfos.add(tableInfo);
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
        return tableInfo;
    }

    public static List<TableInfo> getTableInfos(DBConfig dbConfig) {
        List<TableInfo> tableInfos = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        // 查询数据库所有表的基本信息
        String sql = "select table_name as tableName, table_comment as tableComment, engine as engine, create_time as createTime from information_schema.tables where table_schema = '" + dbConfig.getDbName() + "'";
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
                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(rs.getString("tableName"));
                tableInfo.setTableComment(rs.getString("tableComment"));
                tableInfo.setEngine(rs.getString("engine"));
                // 将下划线变成大写字母
                String upperCaseStr = replaceUnderLineAndUpperCase(tableInfo.getTableName());
                tableInfo.setClassLowercaseName(StringUtils.uncapitalize(upperCaseStr)); // 首字母小写
                tableInfo.setClassUppercaseName(StringUtils.capitalize(upperCaseStr)); // 首字母大写
                if (StringUtils.isNotBlank(rs.getString("createTime"))) tableInfo.setCreateTime(rs.getDate("createTime"));
                tableInfos.add(tableInfo);
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
        return tableInfos;
    }

    /**
     * 获取指定表的字段信息
     *
     * @param dbConfig  数据源配置
     * @param tableName 表名
     * @return 字段信息 List
     */
    public static List<ColumnInfo> getColumnInfosFromTable(DBConfig dbConfig, String tableName) {
        String sql = "select * from  information_schema.columns where table_schema='" + dbConfig.getDbName() + "' and table_name = '" + tableName + "'";
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
                columnInfo.setColumnName(rs.getString("COLUMN_NAME"));
                columnInfo.setColumnType(rs.getString("COLUMN_TYPE"));
                columnInfo.setColumnComment(rs.getString("COLUMN_COMMENT"));
                columnInfo.setDataType(rs.getString("DATA_TYPE"));
                columnInfo.setColumnKey(rs.getString("COLUMN_KEY"));
                columnInfo.setPrimaryKey("PRI".equalsIgnoreCase(rs.getString("COLUMN_KEY")));
                if (columnInfo.isPrimaryKey()) columnInfo.setPrimaryKeyName(columnInfo.getColumnName()); // 主键列名
                columnInfo.setIsNullable(rs.getString("IS_NULLABLE"));
                columnInfo.setExtra(rs.getString("EXTRA"));
                // columnInfo.setAutoIncrement((StringUtils.isNotBlank(rs.getString("Extra")) && rs.getString("Extra").contentEquals("auto_increment")));
                // 将下划线变成大写字母
                String upperCaseStr = replaceUnderLineAndUpperCase(columnInfo.getColumnName());
                columnInfo.setAttrLowercaseName(StringUtils.uncapitalize(upperCaseStr)); // 首字母小写
                columnInfo.setAttrUppercaseName(StringUtils.capitalize(upperCaseStr)); // 首字母大写
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
}
