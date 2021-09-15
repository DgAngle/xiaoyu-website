package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 收入
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/7 10:39
 */
@Data
public class IncomeCatBean extends Pagination {
    private long incomeCatId; // 收入分类主键
    private String incomeCatName; // 收入分类名称
    private int orderNum; // 排序号
    private Date createDt; // 创建时间
    private String createBy; // 创建人
}
