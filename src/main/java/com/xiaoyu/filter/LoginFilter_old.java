// package com.xiaoyu.filter;
//
// import javax.servlet.*;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;
// import java.io.IOException;
//
// /**
//  * @author gqshuang
//  * @version 1.0
//  * @date 2021/9/18 16:54
//  */
// // @WebFilter(urlPatterns = "/*", filterName = "loginFilter")
// public class LoginFilter_old implements Filter {
//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//         HttpServletRequest req = (HttpServletRequest) request;
//         HttpSession session = req.getSession();
//         if (session.getAttribute("userInfo") == null) {
//             req.getRequestDispatcher("/").forward(request, response);
//         } else {
//             chain.doFilter(request, response);
//         }
//     }
// }
