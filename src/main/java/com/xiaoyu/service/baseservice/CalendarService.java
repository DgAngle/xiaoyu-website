package com.xiaoyu.service.baseservice;

import com.xiaoyu.utils.R;
import com.xiaoyu.vo.basevo.CalendarQuery;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/7 17:42
 */
public interface CalendarService {
    // 收藏日历
    R queryCollectionCalendar(CalendarQuery calendarQuery);

    // 收入与收费日历
    R querySpendCalendar(CalendarQuery calendarQuery);

    // 笔记日历
    R queryNoteCalendar(CalendarQuery calendarQuery);

    // 计划日历
    R queryPlanCalendar(CalendarQuery calendarQuery);

    // 时间记录日历
    R queryTimeCalendar(CalendarQuery calendarQuery);
}
