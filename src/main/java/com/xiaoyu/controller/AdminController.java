package com.xiaoyu.controller;

import com.xiaoyu.service.baseservice.AdminService;
import com.xiaoyu.utils.R;
import com.xiaoyu.vo.topvo.CollectionTopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/topPlan")
    @ResponseBody
    public R queryTopPlan() {
        return R.success().data("topPlanList", adminService.queryTopPlan());
    }

    @RequestMapping("/topCollection")
    @ResponseBody
    public R queryTopCollection() {
        return R.success().data("topCollectionList", adminService.queryTopCollection());
    }

    @RequestMapping("/topNote")
    @ResponseBody
    public R queryTopNote() {
        return R.success();
    }

    @RequestMapping("/completePlan")
    @ResponseBody
    public R completePlan(long planId) {
        adminService.completePlanById(planId);
        return R.success().message("操作成功！");
    }


}
