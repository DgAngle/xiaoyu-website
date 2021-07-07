package com.xiaoyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
