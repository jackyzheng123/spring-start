package com.zjx.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2019/11/19 9:39
 * @Version V1.0
 **/
@WebFilter(urlPatterns = "/hello", filterName = "MyFilterLog2")
public class MyFilterLog2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilterLog2 init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("MyFilterLog2 exec " + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
        System.out.println("MyFilterLog2 destroy ...");
    }
}
