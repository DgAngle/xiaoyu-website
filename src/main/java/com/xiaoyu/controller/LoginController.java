package com.xiaoyu.controller;

import com.xiaoyu.entity.UserBean;
import com.xiaoyu.service.baseservice.UserService;
import com.xiaoyu.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 登录模块后台
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/18 10:03
 */
@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    private UserService userService;


    /******************** 注册 ********************/
    @RequestMapping({"/goRegister"})
    public String goRegister() {
        return "admin/register";
    }

    /******************** 登录 ********************/
    @RequestMapping({"", "/goLogin"})
    public String goLogin() {
        return "admin/login";
    }

    @RequestMapping({"/login/doLogin"})
    @ResponseBody
    public R login(UserBean userBean, HttpSession session) {
        System.out.println("doLogin user = " + userBean);
        if (StringUtils.isBlank(userBean.getUsername()) || StringUtils.isNotBlank(userBean.getPassword()))
            return R.error();

        userService.queryUser(userBean);

        session.setAttribute("userInfo", userBean);
        return R.success().data("msg", "登录成功！");
    }
}
