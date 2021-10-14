package com.xiaoyu.vo.basevo;

import com.xiaoyu.common.Pagination;
import com.xiaoyu.utils.DateUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/14 15:28
 */
@Data
public class TimeRecordQuery extends Pagination {
    private long timeRecordId; // 时间记录主键
    private String timeRecordName; // 时间记录名称
    private String timeRecordDt; // 时间记录日期
    private String timeRecordAddress; // 记录地点

    private String timeRecordStartDt; // 开始日期
    private String timeRecordEndDt; // 结束日期

    public String getTimeRecordStartDt() {
        if (StringUtils.isNotBlank(timeRecordDt)) timeRecordStartDt = DateUtil.dateOfBegin(DateUtil.stringToDate(timeRecordDt, DateUtil.default_format_date_day));
        return timeRecordStartDt;
    }

    public String getTimeRecordEndDt() {
        if (StringUtils.isNotBlank(timeRecordDt)) timeRecordStartDt = DateUtil.dateOfEnd(DateUtil.stringToDate(timeRecordDt, DateUtil.default_format_date_day));
        return timeRecordEndDt;
    }
}
