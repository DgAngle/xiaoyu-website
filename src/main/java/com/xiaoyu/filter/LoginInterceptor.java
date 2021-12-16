package com.xiaoyu.filter;

import com.alibaba.fastjson.JSON;
import com.sun.javafx.scene.shape.PathUtils;
import com.xiaoyu.entity.UserBean;
import com.xiaoyu.utils.PathUtil;
import com.xiaoyu.utils.UserUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/16 13:50
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception err)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserBean user = UserUtil.getUser();
        // System.out.println(JSON.toJSON(user));
        // 如果登录状态为空则重定向到登录页面，并返回false，不执行原来controller的方法
        if (user == null) {
            response.sendRedirect(PathUtil.login_path);
            return false;
        }
        return true;
    }
}
