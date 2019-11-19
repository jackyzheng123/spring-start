package com.zjx.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description
 * @Author Carson Cheng
 * @Date 2019/11/19 9:25
 * @Version V1.0
 **/
@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean () {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilterLog1());
        filterRegistrationBean.addUrlPatterns("/hello");
        filterRegistrationBean.setName("LogFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}