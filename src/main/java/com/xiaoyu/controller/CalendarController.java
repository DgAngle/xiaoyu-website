package com.xiaoyu.controller;

import com.xiaoyu.service.baseservice.CalendarService;
import com.xiaoyu.utils.R;
import com.xiaoyu.vo.basevo.CalendarQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/7 17:34
 */
@Controller
public class CalendarController {

    private static final String calendar_path = "pagelist/calendar";

    @Autowired
    private CalendarService calendarService;

    /*********************** 页面跳转 ***********************/

    // 收藏日历
    @RequestMapping({"calendar/openCollectionCalendar"})
    public String openCollectionCalendar() {
        return this.calendar_path + "/collectionCalendar";
    }

    // 收入与消费日历
    @RequestMapping({"calendar/openSpendCalendar"})
    public String openSpendCalendar() {
        return this.calendar_path + "/spendCalendar";
    }

    // 笔记日历
    @RequestMapping({"calendar/openNoteCalendar"})
    public String openNoteCalendar() {
        return this.calendar_path + "/noteCalendar";
    }

    // 计划日历
    @RequestMapping({"calendar/openPlanCalendar"})
    public String openPlanCalendar() {
        return this.calendar_path + "/planCalendar";
    }

    // 时间记录日历
    @RequestMapping({"calendar/openTimeCalendar"})
    public String openTimeCalendar() {
        return this.calendar_path + "/timeCalendar";
    }

    /*********************** 数据查询 ***********************/

    // 查询收藏日历数据
    @RequestMapping({"calendar/queryCollectionCalendar"})
    @ResponseBody
    public R queryCollectionCalendar(CalendarQuery calendarQuery) {
        return calendarService.queryCollectionCalendar(calendarQuery);
    }

    // 收入与消费日历
    @RequestMapping({"calendar/querySpendCalendar"})
    @ResponseBody
    public R querySpendCalendar(CalendarQuery calendarQuery) {
        return calendarService.querySpendCalendar(calendarQuery);
    }

    // 笔记日历
    @RequestMapping({"calendar/queryNoteCalendar"})
    @ResponseBody
    public R queryNoteCalendar(CalendarQuery calendarQuery) {
        return calendarService.queryNoteCalendar(calendarQuery);
    }

    // 计划日历
    @RequestMapping({"calendar/queryPlanCalendar"})
    @ResponseBody
    public R queryPlanCalendar(CalendarQuery calendarQuery) {
        return calendarService.queryPlanCalendar(calendarQuery);
    }

    // 时间记录日历
    @RequestMapping({"calendar/queryTimeCalendar"})
    @ResponseBody
    public R queryTimeCalendar(CalendarQuery calendarQuery) {
        return calendarService.queryTimeCalendar(calendarQuery);
    }


}
