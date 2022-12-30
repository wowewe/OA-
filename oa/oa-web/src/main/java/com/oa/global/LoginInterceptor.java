package com.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取URL判断是否拦截
        String url = httpServletRequest.getRequestURI();//获取请求路径
        System.out.println(url);
        if(url.toLowerCase().indexOf("login") >= 0){
            return true;
        }
        //判断当前状态是否登录
        HttpSession session = httpServletRequest.getSession();
        //判断emp是否为null,说明session中存储了emp,说明用户已经登录成功
        if(session.getAttribute("employee") != null){
            return true;
        }
        httpServletResponse.sendRedirect("/to_login");
        return false; //禁止访问
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
