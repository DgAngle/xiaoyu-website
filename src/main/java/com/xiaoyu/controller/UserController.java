package com.xiaoyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户后台控制
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("userList")
    public String goUserList() {
        return "user/userList";
    }
}
