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
public class SpendQuery extends Pagination {
    private long spendCatId; // 消费分类主键
    private String spendName; // 消费名称
    private BigDecimal spendMoney; // 消费金额
    private String spendDate; // 消费时间
    private String spendContent; // 消费内容
    private String spendStartDate; // 开始日期
    private String spendEndDate; // 结束日期
    private String createBy; // 创建人

    public String getSpendStartDate() {
        if (StringUtils.isNotBlank(spendStartDate)) spendStartDate = DateUtil.dateOfBegin(DateUtil.stringToDate(spendStartDate, DateUtil.default_format_date_day));
        return spendStartDate;
    }

    public String getSpendEndDate() {
        if (StringUtils.isNotBlank(spendEndDate)) spendEndDate = DateUtil.dateOfEnd(DateUtil.stringToDate(spendEndDate, DateUtil.default_format_date_day));
        return spendEndDate;
    }
}
