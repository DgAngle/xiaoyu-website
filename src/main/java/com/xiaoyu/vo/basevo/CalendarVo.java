package com.xiaoyu.vo.basevo;

import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/7 17:36
 */
@Data
public class CalendarVo {
    private String id; // 用于获取event事件
    private String title; // 显示的文字
    private String start; // 日历渲染开始时间
    private String end; // 日历渲染结束时间
    private String backgroundColor; // 自定义背景颜色
    private String eventBorderColor; // 自定义背景框颜色
    private String eventTextColor; // 自定义文字颜色
    private String className; // 单个css样式类
    private String[] classNames; // 多个css样式类
    private Boolean hour12; // 是否12小时制
    private Boolean omitZeroMinute; // 是否省略零分
    // 'h:mm': like '5:00', for agendaWeek and agendaDay,
    // 'h(:mm)t': like '7p', for all other views,
    // 'H(:mm)': uppercase H for 24-hour clock,
    private String timeFormat;

}
