package com.xiaoyu.utils.generate;

import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/14 18:00
 */
@Data
public class ColumnClass {
    private String columnName; // 数据库字段名称
    private String columnType; // 数据库字段类型
    private String changeColumnName; // 数据库字段首字母小写且去掉下划线字符串
    private String columnComment; // 数据库字段注释
}
