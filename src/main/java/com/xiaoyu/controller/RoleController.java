package com.xiaoyu.controller;

import com.xiaoyu.entity.RoleBean;
import com.xiaoyu.entity.UserBean;
import com.xiaoyu.service.RoleService;
import com.xiaoyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限后台控制
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/7/13 14:39
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("roleList")
    public String goRoleList(Model model, RoleBean roleBean) {
        model.addAttribute("roleList", roleService.queryRole(roleBean));
        return "role/roleList";
    }

}
