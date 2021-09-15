package com.xiaoyu.controller;

import com.xiaoyu.service.baseservice.AdminService;
import com.xiaoyu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping({"index"})
    public String goIndex() {
        return "admin/index";
    }

    @RequestMapping({"menuConfig"})
    public String goMenuConfig() {
        return "admin/menuConfig";
    }

    // 计划
    @RequestMapping("/topPlan")
    @ResponseBody
    public R queryTopPlan() {
        return R.success().data("topPlanList", adminService.queryTopPlan());
    }

    // 消费
    @RequestMapping("/topSpend")
    @ResponseBody
    public R queryTopSpend() {
        return R.success()
                .data("topSpendList", adminService.queryTopSpend())
                .data("totalSpendMoney", adminService.queryTotalSpendMoney());
    }

    // 收入
    @RequestMapping("/topIncome")
    @ResponseBody
    public R queryTopIncome() {
        return R.success()
                .data("topIncomeList", adminService.queryTopIncome())
                .data("totalIncomeMoney", adminService.queryTotalIncomeMoney());
    }

    // 收藏
    @RequestMapping("/topCollection")
    @ResponseBody
    public R queryTopCollection() {
        return R.success().data("topCollectionList", adminService.queryTopCollection());
    }

    // 笔记
    @RequestMapping("/topNote")
    @ResponseBody
    public R queryTopNote() {
        return R.success().data("topNoteList", adminService.queryTopNote());
    }

    // 完成计划
    @RequestMapping("/completePlan")
    @ResponseBody
    public R completePlan(long planId) {
        adminService.completePlanById(planId);
        return R.success().message("操作成功！");
    }


}
