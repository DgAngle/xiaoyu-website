package com.xiaoyu.controller;

import com.xiaoyu.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class AdminController {
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
        return R.success();
    }

    @RequestMapping("/topCollection")
    @ResponseBody
    public R queryTopCollection() {
        return R.success();
    }

    @RequestMapping("/topNote")
    @ResponseBody
    public R queryTopNote() {
        return R.success();
    }
}
