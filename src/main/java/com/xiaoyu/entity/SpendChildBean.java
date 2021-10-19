package com.xiaoyu.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 子花费
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/19 10:49
 */
@Data
public class SpendChildBean {
    private long spendChildId; // 子消费主键
    private long spendId; // 消费主键（父主键）
    private long spendCatId; // 消费分类主键
    private String spendChildName; // 子消费名称
    private BigDecimal spendChildMoney; // 子消费金额
    private Date spendChildDate; // 子消费时间
    private String spendChildContent; // 子消费内容
    private Date createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
