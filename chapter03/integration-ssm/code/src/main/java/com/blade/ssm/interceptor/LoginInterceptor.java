package com.blade.ssm.interceptor;

import com.blade.ssm.dto.LoginFailedResultJson;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URI = {
        "/login",
        "/api/user/login"
    };

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession httpSession = httpServletRequest.getSession();
        System.out.println("****拦截器****HttpSession Is New: " + httpSession.isNew());
        System.out.println("****拦截器****The new jsessionid: " + httpSession.getId());
        System.out.println("****拦截器****preHandle done");

//        LoginFailedResultJson json = new LoginFailedResultJson();
//        System.out.println(json.getCode());
//        System.out.println(json.getCount());
//        System.out.println(json.getMsg());

//        res.setCode(12);
//        System.out.println(res.getCode());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        /*
        * 模块设计中有一句话
        * 叫做一个数据流设计优秀的模块，会将所有的需求资源写在参数表里
        * 本方法的参数中一看就知道，这个方法是要在页面开始渲染之前，进行一次截断，来进行一些操作
        * */
        System.out.println("****拦截器****postHandle done");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("****拦截器****afterHandle done\n##################################请求结束####################################");
    }
}
