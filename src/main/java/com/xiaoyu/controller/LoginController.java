package com.xiaoyu.controller;

import com.alibaba.fastjson.JSON;
import com.xiaoyu.entity.UserBean;
import com.xiaoyu.service.baseservice.UserService;
import com.xiaoyu.utils.R;
import com.xiaoyu.utils.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

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
        logger.info("接收参数：{}", JSON.toJSON(userBean));
        if (StringUtils.isBlank(userBean.getUsername()) || StringUtils.isBlank(userBean.getPassword()))
            return R.error();

        UserBean user = userService.queryUser(userBean);
        // LogUtils.getLog().info("查询结果：" + JSON.toJSON(user));
        logger.info("查询结果：{}", JSON.toJSON(user));
        if (user == null) return R.error().data("msg", "用户名或密码错误！");

        session.setAttribute(UserUtil.USER_ATTRIBUTE, user);
        return R.success().data("msg", "登录成功！").data("user", user);
    }

    /******************** 退出 ********************/
    @RequestMapping({"/exit"})
    public String exit() {
        UserUtil.exit();
        return "admin/login";
    }
}
