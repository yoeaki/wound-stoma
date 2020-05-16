package com.linkgoo.framework.web.core;


import com.linkgoo.framework.web.core.interceptor.PageableInterceptor;
import com.linkgoo.framework.web.core.interceptor.ValidatedInterceptor;
import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MVCconfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册参数校验拦截
        InterceptorRegistration validateRegistration = registry.addInterceptor(new ValidatedInterceptor());
        validateRegistration.addPathPatterns("/**");
        //排除错误页面
        validateRegistration.excludePathPatterns("/error");
    }

    @Bean
    @Order(1)
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

    @Bean
    @Order(2)
    public PageableInterceptor pageableInterceptor() {
        return new PageableInterceptor();
    }

}
