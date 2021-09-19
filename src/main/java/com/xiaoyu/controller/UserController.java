package com.xiaoyu.controller;

import com.xiaoyu.entity.RoleBean;
import com.xiaoyu.entity.UserBean;
import com.xiaoyu.service.baseservice.RoleService;
import com.xiaoyu.service.baseservice.UserService;
import com.xiaoyu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户后台控制
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final String user_path = "pagelist/user";

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/goList")
    public String goUserList() {
        return this.user_path + "/userList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R catList(UserBean userBean) {
        return R.success().data("userList", userService.queryUserList(userBean)).data("roleList", roleService.queryRole(new RoleBean()));
    }

    @RequestMapping("/add")
    @ResponseBody
    public R add(UserBean userBean) {
        userService.addUser(userBean);
        return R.success().data("msg", "添加成功！");
    }

}
