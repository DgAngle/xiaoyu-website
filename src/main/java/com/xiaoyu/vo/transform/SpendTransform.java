package com.xiaoyu.vo.transform;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/3 8:52
 */
@Data
public class SpendTransform {
    private String spendId; // 消费主键
    private String spendCatId; // 消费分类主键
    private String spendName; // 消费名称
    private String spendMoney; // 消费金额
    private String spendDate; // 消费时间
    private String spendContent; // 消费内容
    private String createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
