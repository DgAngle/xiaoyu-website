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

    @RequestMapping({"plan/index"})
    public String goIndex() {
        return this.mobile_plan_path + "/planIndex";
    }
}
