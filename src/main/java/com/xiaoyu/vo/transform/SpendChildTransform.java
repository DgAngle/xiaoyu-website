package com.xiaoyu.vo.transform;

import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/3 8:52
 */
@Data
public class SpendChildTransform {
    private String spendChildId; // 子消费主键
    private String spendId; // 消费主键
    private String spendCatId; // 子消费分类主键
    private String spendChildName; // 子消费名称
    private String spendChildMoney; // 子消费金额
    private String spendChildDate; // 子消费时间
    private String spendChildContent; // 子消费内容
    private String createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
