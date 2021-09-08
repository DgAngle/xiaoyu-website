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
public class IncomeBean extends Pagination {
    private long incomeId; // 收入主键
    private long incomeCatId; // 收入分类主键
    private String incomeName; // 收入名称
    private BigDecimal incomeMoney; // 收入金额
    private Date incomeDate; // 收入时间
    private String incomeContent; // 收入内容
    private Date createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
