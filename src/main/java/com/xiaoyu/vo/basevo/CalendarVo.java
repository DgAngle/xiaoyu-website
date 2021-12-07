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
}
