package com.xiaoyu.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/12/16 13:47
 */
// @Configuration
public class LoginFilter implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    /**
     * 不需要登录拦截的url:登录相关
     */
    final String[] excludePathPatternPaths = {
            // 登录相关请求
            "/goRegister",
            "/goLogin",
            "/login/doLogin",
            "/user/add",
            // 静态资源 static
            "/css/**",
            "/js/**",
            "/images/**",
            "/plugs/**",
            "/favicon.ico",
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志拦截器
        //registry.addInterceptor(logInterceptor).addPathPatterns("/**");
        // 登录拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathPatternPaths);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // configurer.enable();
    }

    // @Bean
    // public InternalResourceViewResolver viewResolver() {
    //     InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    //     resolver.setPrefix("/templates/pages/");
    //     resolver.setSuffix(".html");
    //     resolver.setViewClass(JstlView.class);
    //     resolver.setOrder(0);
    //     return resolver;
    // }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/pages/login.html").setViewName("login");
        registry.addViewController("/pages/register.html").setViewName("register");
    }

}
