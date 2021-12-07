package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.dao.CalendarMapper;
import com.xiaoyu.service.baseservice.CalendarService;
import com.xiaoyu.utils.DateUtil;
import com.xiaoyu.utils.R;
import com.xiaoyu.vo.basevo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/7 17:42
 */
@Service
public class CalendarServiceImpl implements CalendarService {
    @Resource
    private CalendarMapper calendarMapper;

    // 收藏日历
    @Override
    public R queryCollectionCalendar(CalendarQuery calendarQuery) {
        List<CollectionVo> collectionVos = calendarMapper.queryCollectionCalendar(calendarQuery);
        List<CalendarVo> calendarList = new ArrayList<>();
        Optional.ofNullable(collectionVos).orElse(new ArrayList<>()).forEach((collection) -> {
            CalendarVo calendar = new CalendarVo();
            calendar.setId("collection-" + collection.getCollectionId());
            calendar.setTitle(collection.getCollectionName());
            calendar.setStart(DateUtil.dateToString(collection.getCreateDt()));
            calendarList.add(calendar);
        });
        return R.success().data("calendarList", calendarList);
    }

    // 收入与消费日历
    @Override
    public R querySpendCalendar(CalendarQuery calendarQuery) {
        List<CalendarVo> calendarList = new ArrayList<>();

        // 消费
        List<SpendVo> spendVos = calendarMapper.querySpendCalendar(calendarQuery);
        // List<CalendarVo> spendCalendarList = new ArrayList<>();
        Optional.ofNullable(spendVos).orElse(new ArrayList<>()).forEach((spend) -> {
            CalendarVo calendar = new CalendarVo();
            calendar.setId("spend-" + spend.getSpendId());
            calendar.setTitle(spend.getSpendName());
            calendar.setStart(spend.getSpendDateStr());
            calendar.setClassName("cal-spend-item");
            calendarList.add(calendar);
        });

        // 收入
        List<IncomeVo> incomeVos = calendarMapper.queryIncomeCalendar(calendarQuery);
        // List<CalendarVo> incomeCalendarList = new ArrayList<>();
        Optional.ofNullable(incomeVos).orElse(new ArrayList<>()).forEach((income) -> {
            CalendarVo calendar = new CalendarVo();
            calendar.setId("income-" + income.getIncomeId());
            calendar.setTitle(income.getIncomeName());
            calendar.setStart(income.getIncomeDateStr());
            calendar.setClassName("cal-income-item");
            calendarList.add(calendar);
        });

        return R.success()
                .data("calendarList", calendarList);
    }

    // 笔记日历
    @Override
    public R queryNoteCalendar(CalendarQuery calendarQuery) {
        List<NoteVo> noteVos = calendarMapper.queryNoteCalendar(calendarQuery);
        List<CalendarVo> calendarList = new ArrayList<>();
        Optional.ofNullable(noteVos).orElse(new ArrayList<>()).forEach((note) -> {
            CalendarVo calendar = new CalendarVo();
            calendar.setId("note-" + note.getNoteId());
            calendar.setTitle(note.getNoteName());
            calendar.setStart(note.getCreateDtStr());
            calendarList.add(calendar);
        });
        return R.success().data("calendarList", calendarList);
    }

    // 计划日历
    @Override
    public R queryPlanCalendar(CalendarQuery calendarQuery) {
        List<PlanVo> planVos = calendarMapper.queryPlanCalendar(calendarQuery);
        List<CalendarVo> calendarList = new ArrayList<>();
        Optional.ofNullable(planVos).orElse(new ArrayList<>()).forEach((plan) -> {
            CalendarVo calendar = new CalendarVo();
            calendar.setId("plan-" + plan.getPlanId());
            calendar.setTitle(plan.getPlanName());
            calendar.setStart(DateUtil.dateToString(plan.getCreateDt()));
            calendarList.add(calendar);
        });
        return R.success().data("calendarList", calendarList);
    }

    // 时间记录日历
    @Override
    public R queryTimeCalendar(CalendarQuery calendarQuery) {
        List<TimeRecordVo> timeRecordVo = calendarMapper.queryTimeCalendar(calendarQuery);
        List<CalendarVo> calendarList = new ArrayList<>();
        Optional.ofNullable(timeRecordVo).orElse(new ArrayList<>()).forEach((timeRecord) -> {
            CalendarVo calendar = new CalendarVo();
            calendar.setId("timeRecord-" + timeRecord.getTimeRecordId());
            calendar.setTitle(timeRecord.getTimeRecordName());
            calendar.setStart(timeRecord.getTimeRecordDtStr());
            calendarList.add(calendar);
        });
        return R.success().data("calendarList", calendarList);
    }
}
