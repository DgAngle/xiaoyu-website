package com.xiaoyu.mobile.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/3 14:36
 */
@Controller
@RequestMapping("mobile")
public class MobilePlanController {
    private static final String mobile_plan_path = "mobile/plan";

    // 进入首页
    @RequestMapping({"plan/index"})
    public String goIndex() {
        return this.mobile_plan_path + "/planIndex";
    }

    // 进入本周
    @RequestMapping({"plan/week"})
    public String goWeek() {
        return this.mobile_plan_path + "/planWeek";
    }

    // 进入本日
    @RequestMapping({"plan/daily"})
    public String goDaily() {
        return this.mobile_plan_path + "/planDaily";
    }
}
