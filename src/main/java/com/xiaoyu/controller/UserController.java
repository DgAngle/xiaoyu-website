package com.xiaoyu.controller;

import com.xiaoyu.entity.UserBean;
import com.xiaoyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户后台控制
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("userList")
    public String goUserList(Model model, UserBean userBean) {
        model.addAttribute("userList", userService.queryUser(userBean));
        return "user/userList";
    }


    public String queryUser(Model model) {
        return "user/userList";
    }
}
