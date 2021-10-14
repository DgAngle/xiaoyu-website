package com.xiaoyu.vo.basevo;

import com.xiaoyu.entity.TimeRecordBean;
import com.xiaoyu.utils.DateUtil;
import lombok.Data;

@Data
public class TimeRecordVo extends TimeRecordBean {
    private String timeRecordDtStr; // 日期格式化
    private String timeRecordDtFormStr; // 日期格式化

    public String getTimeRecordDtStr() {
        if (this.getTimeRecordDt() != null)
            timeRecordDtStr = DateUtil.dateToString(this.getTimeRecordDt(), DateUtil.default_format_date_day);
        return timeRecordDtStr;
    }

    public String getTimeRecordDtFormStr() {
        if (this.getTimeRecordDt() != null)
            timeRecordDtFormStr = DateUtil.dateToString(this.getTimeRecordDt(), DateUtil.default_format_date_seconds);
        return timeRecordDtFormStr;
    }
}
