package com.xiaoyu.dao;

import com.xiaoyu.utils.R;
import com.xiaoyu.vo.basevo.*;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/7 17:46
 */
public interface CalendarMapper {
    // 收藏日历
    List<CollectionVo> queryCollectionCalendar(CalendarQuery calendarQuery);

    // 消费日历数据
    List<SpendVo> querySpendCalendar(CalendarQuery calendarQuery);

    // 收入日历数据
    List<IncomeVo> queryIncomeCalendar(CalendarQuery calendarQuery);

    // 笔记日历
    List<NoteVo> queryNoteCalendar(CalendarQuery calendarQuery);

    // 计划日历
    List<PlanVo> queryPlanCalendar(CalendarQuery calendarQuery);

    // 时间记录日历
    List<TimeRecordVo> queryTimeCalendar(CalendarQuery calendarQuery);
}
