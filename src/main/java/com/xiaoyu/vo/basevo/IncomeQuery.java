package com.xiaoyu.vo.basevo;

import com.xiaoyu.common.Pagination;
import com.xiaoyu.utils.DateUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/3 12:58
 */
@Data
public class IncomeQuery extends Pagination {
    private long incomeCatId; // 收入分类主键
    private String incomeName; // 收入名称
    private BigDecimal incomeMoney; // 收入金额
    private String incomeDate; // 收入时间
    private String incomeContent; // 收入内容
    private String incomeStartDate; // 开始日期
    private String incomeEndDate; // 结束日期

    public String getIncomeStartDate() {
        if (StringUtils.isNotBlank(incomeStartDate)) incomeStartDate = DateUtil.dateOfBegin(DateUtil.stringToDate(incomeStartDate, DateUtil.default_format_date_day));
        return incomeStartDate;
    }

    public String getIncomeEndDate() {
        if (StringUtils.isNotBlank(incomeEndDate)) incomeEndDate = DateUtil.dateOfEnd(DateUtil.stringToDate(incomeEndDate, DateUtil.default_format_date_day));
        return incomeEndDate;
    }
}
