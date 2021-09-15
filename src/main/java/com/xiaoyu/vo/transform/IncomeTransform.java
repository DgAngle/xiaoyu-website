package com.xiaoyu.vo.transform;

import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/7 11:20
 */
@Data
public class IncomeTransform {
    private String incomeId; // 收入主键
    private String incomeCatId; // 收入分类主键
    private String incomeName; // 收入名称
    private String incomeMoney; // 收入金额
    private String incomeDate; // 收入时间
    private String incomeContent; // 收入内容
    private String createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
