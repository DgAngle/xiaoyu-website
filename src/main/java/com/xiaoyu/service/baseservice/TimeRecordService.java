package com.xiaoyu.service.baseservice;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.TimeRecordBean;
import com.xiaoyu.vo.basevo.TimeRecordQuery;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/14 15:12
 */
public interface TimeRecordService {

    ListResult<TimeRecordBean> queryTimeRecordList(TimeRecordQuery timeRecordQuery);

    int addTimeRecord(TimeRecordBean timeRecordBean);

    TimeRecordBean queryTimeRecordDetailById(long timeRecordId);

    int updateTimeRecord(TimeRecordBean timeRecordBean);

    int deleteTimeRecordById(long timeRecordId);

    Map<String, Long> queryTotalTime(TimeRecordQuery timeRecordQuery);
}
