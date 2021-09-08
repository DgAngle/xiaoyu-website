package com.xiaoyu.vo.basevo;

import com.xiaoyu.entity.IncomeBean;
import com.xiaoyu.utils.DateUtil;
import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 10:07
 */
@Data
public class IncomeVo extends IncomeBean {
    private String incomeCatName; // 分类名称
    private String incomeDateStr; // 日期格式化

    public String getIncomeDateStr() {
        if (this.getIncomeDate() != null) incomeDateStr = DateUtil.dateToString(this.getIncomeDate(), DateUtil.default_format_date_min);
        return incomeDateStr;
    }
}
