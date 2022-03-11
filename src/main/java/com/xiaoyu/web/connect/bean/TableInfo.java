package com.xiaoyu.web.connect.bean;

import lombok.Data;

/**
 * 数据表信息
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:17
 */
@Data
public class TableInfo {
    private String field; // 英文字段
    private String type; // 字段类型
    private boolean isNull; // 字段是否允许为空
    private boolean isKey; // 字段是否是主键
    private boolean isAutoIncrement; // 字段是否自增长
    private String comment; // 中文注释
}
