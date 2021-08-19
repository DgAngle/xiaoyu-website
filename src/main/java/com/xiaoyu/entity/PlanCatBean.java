package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 计划分类
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/19 10:17
 */
@Data
public class PlanCatBean extends Pagination {
    private long planCatId; // 计划分类主键
    private String planCatName; // 计划分类名称
    private int orderNum; // 排序号
    private Date createDt; // 创建时间
    private String createBy; // 创建人
}
