// package com.xiaoyu.config;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
// /**
//  * 登录配置
//  *
//  * @author gqshuang
//  * @version 1.0
//  * @date 2021/9/18 16:32
//  */
// // @Configuration
// public class LoginConfig implements WebMvcConfigurer {
//
//     @Override
//     public void addInterceptors(InterceptorRegistry registry) {
//         // 注册登录拦截器
//         InterceptorRegistration loginInterceptor = registry.addInterceptor(new LoginInterceptor());
//         loginInterceptor.addPathPatterns("/**");// 拦截所有路径
//         loginInterceptor.excludePathPatterns(
//                 "/"
//                 , "/goLogin"
//                 , "/goRegister"
//                 , "/user/add"
//                 , "/login/doLogin"
//                 , "/code/statusList"
//                 , "/favicon.ico"
//                 , "/static/**"
//                 , "/plugs/**"
//                 , "/js/**"
//                 , "/css/**"
//                 , "/**.js"
//                 , "/**.css"
//         );
//
//     }
// }
