package com.xiaoyu.vo.basevo;

import com.xiaoyu.entity.SpendBean;
import com.xiaoyu.utils.DateUtil;
import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 10:07
 */
@Data
public class SpendVo extends SpendBean {
    private String spendCatName; // 分类名称
    private String spendDateStr; // 日期格式化

    public String getSpendDateStr() {
        if (this.getSpendDate() != null) spendDateStr = DateUtil.dateToString(this.getSpendDate());
        return spendDateStr;
    }
}
