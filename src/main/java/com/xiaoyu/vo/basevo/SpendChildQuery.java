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
public class SpendChildQuery extends Pagination {
    private long spendCatId; // 消费分类主键
    private String spendId; // 消费主键
    private String spendChildName; // 子消费名称
    private BigDecimal spendChildMoney; // 子消费金额
    private String spendChildDate; // 子消费时间
    private String spendChildContent; // 子消费内容
    private String spendChildStartDate; // 子开始日期
    private String spendChildEndDate; // 子结束日期

    public String getSpendChildStartDate() {
        if (StringUtils.isNotBlank(spendChildStartDate)) spendChildStartDate = DateUtil.dateOfBegin(DateUtil.stringToDate(spendChildStartDate, DateUtil.default_format_date_day));
        return spendChildStartDate;
    }

    public String getSpendChildEndDate() {
        if (StringUtils.isNotBlank(spendChildEndDate)) spendChildEndDate = DateUtil.dateOfEnd(DateUtil.stringToDate(spendChildEndDate, DateUtil.default_format_date_day));
        return spendChildEndDate;
    }
}
