package com.xiaoyu.vo.basevo;

import com.xiaoyu.entity.SpendChildBean;
import com.xiaoyu.utils.DateUtil;
import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 10:07
 */
@Data
public class SpendChildVo extends SpendChildBean {
    private String spendCatName; // 分类名称
    private String spendName; // 主消费名称
    private String spendChildDateStr; // 日期格式化

    public String getSpendChildDateStr() {
        if (this.getSpendChildDate() != null) spendChildDateStr = DateUtil.dateToString(this.getSpendChildDate(), DateUtil.default_format_date_min);
        return spendChildDateStr;
    }
}
