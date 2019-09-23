package com.blade.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter "+filterConfig.getFilterName() +
                            " from "+filterConfig.getInitParameter("Admin") +
                            " with context "+filterConfig.getServletContext() +
                            " is working");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 获取客户机的 IP 地址
        String ipAddress = servletRequest.getRemoteAddr();

        // 记录 IP 地址和当前时间戳
        System.out.println("IP "+ ipAddress + ", Time "
                + new Date().toString());

        // 把请求传回过滤链
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
