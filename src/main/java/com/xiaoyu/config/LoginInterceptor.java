// package com.xiaoyu.config;
//
// import com.xiaoyu.entity.UserBean;
// import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// /**
//  * 登录拦截器
//  *
//  * @author gqshuang
//  * @version 1.0
//  * @date 2021/9/18 16:24
//  */
// public class LoginInterceptor implements HandlerInterceptor {
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         UserBean user = (UserBean) request.getSession().getAttribute("userInfo");
//         if (user != null) return true;
//         else request.getRequestDispatcher("/").forward(request, response);
//         return false;
//     }
//
//     @Override
//     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//     }
//
//     @Override
//     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//     }
// }
