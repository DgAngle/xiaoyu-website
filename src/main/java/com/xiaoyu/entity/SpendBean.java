package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 消费数据
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 9:07
 */
@Data
public class SpendBean extends Pagination {
    private long spendId; // 消费主键
    private long spendCatId; // 消费分类主键
    private String spendName; // 消费名称
    private BigDecimal spendMoney; // 消费金额
    private Date spendDate; // 消费时间
    private String spendContent; // 消费内容
    private Date createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}