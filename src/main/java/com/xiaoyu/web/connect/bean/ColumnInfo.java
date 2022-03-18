package com.xiaoyu.web.connect.bean;

import lombok.Data;

/**
 * 字段信息
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/17 16:13
 */
@Data
public class ColumnInfo {
    // select * from  information_schema.columns where table_schema='数据库' and table_name='表'
    private String columnName; // 英文列名
    private String columnType; // 列名类型(包含范围)，如：varchar(50)
    private String dataType; // 列名类型(不包含范围)，如：varchar
    private String isNullable; // 字段是否允许为空(NO/YES)
    private String columnKey; // 字段是否允许为空(NO/YES)
    private boolean isPrimaryKey; // 字段是否是主键
    private String primaryKeyName; // 主键字段英文列名
    private String columnComment; // 中文注释
    private String attrUppercaseName; // 属性名称(第一个字母大写)，如：user_name => UserName
    private String attrLowercaseName; // 属性名称(第一个字母小写)，如：user_name => userName
    private String extra; // auto_increment
}
