package com.xiaoyu.utils;

import com.xiaoyu.config.SysParamConfig;
import com.xiaoyu.entity.UserBean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 封装用户工具类, 用于快速获取当前登录的用户
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/11/29 9:38
 */
public class UserUtil {
    public static final String USER_ATTRIBUTE = "user"; // session保存的用户 - key
    public static final String USER_ADMIN = SysParamConfig.sysParamsMap.get(SysParamConfig.sysParam_userAdmin); // 管理员账号

    // 构造方法私有化
    private UserUtil() {
    }

    // 获取当前用户信息
    public static UserBean getUser() {
        return (UserBean) getSession().getAttribute(USER_ATTRIBUTE);
    }

    // 判断当前用户是否超级管理员
    public static boolean isAdmin() {
        return USER_ADMIN.equals(getUser().getUsername());
    }

    // 获取HttpSession
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    // 获取HttpServletRequest
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    // 注销用户
    public static void exit() {
        getSession().invalidate();
    }
}
