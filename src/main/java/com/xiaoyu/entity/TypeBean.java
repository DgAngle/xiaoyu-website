package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 类型-全局配置
 */
@Data
public class TypeBean extends Pagination {
    private long typeId; // 类型主键
    private String typeName; // 类型名称
    private int orderNum; // 排序号
    private Date createDt; // 创建时间
}
