package com.xiaoyu.dao;

import com.xiaoyu.entity.TimeRecordBean;
import com.xiaoyu.vo.basevo.TimeRecordQuery;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/14 15:12
 */
public interface TimeRecordMapper {

    int queryTimeRecordListCount(TimeRecordQuery timeRecordQuery);

    List<TimeRecordBean> queryTimeRecordList(TimeRecordQuery timeRecordQuery);

    int addTimeRecord(TimeRecordBean timeRecordBean);

    TimeRecordBean queryTimeRecordDetailById(long timeRecordId);

    int updateTimeRecord(TimeRecordBean timeRecordBean);

    int deleteTimeRecordById(long timeRecordId);

    List<TimeRecordBean> queryTotalTime(TimeRecordQuery timeRecordQuery);

}
