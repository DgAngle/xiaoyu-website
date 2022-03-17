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
    private String field; // 英文字段
    private String type; // 字段类型
    private boolean isNull; // 字段是否允许为空
    private boolean isKey; // 字段是否是主键
    private boolean isAutoIncrement; // 字段是否自增长
    private String comment; // 中文注释

    // private String columnName; // 列名
    // private String dataType; // 列名类型
    private String attrUppercaseName; // 属性名称(第一个字母大写)，如：user_name => UserName
    private String attrLowercaseName; // 属性名称(第一个字母小写)，如：user_name => userName
    private String attrType; // 属性类型
    private String extra; // auto_increment
}
