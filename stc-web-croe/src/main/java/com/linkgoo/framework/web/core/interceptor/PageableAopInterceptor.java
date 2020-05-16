package com.linkgoo.framework.web.core.interceptor;

import com.alibaba.fastjson.JSON;
import com.linkgoo.framework.web.core.util.HttpUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

/**
 * PageableAopInterceptor class
 *
 * @description: AOP用于判断是否需要进行分页
 *
 * @author qixiao.bi
 * @date 2020-01-09 15:01
 */
@Component
@Aspect
public class PageableAopInterceptor {

    @Autowired
    HttpServletRequest request;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution( com.linkgoo.framework.web.core.interceptor.Page  *..*.*(..)) ")
    public Object beforeMapper(ProceedingJoinPoint joinPoint) throws Throwable {
        Class<?>[] interfaces = joinPoint.getThis().getClass().getInterfaces();
        if (interfaces.length == 0) {
            return joinPoint.proceed();
        }
        for (Class interf : interfaces) {
            Annotation[] annotations = interf.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Mapper.class) || annotation.annotationType().equals(Repository.class)) {
                    startPage();
                    return joinPoint.proceed();
                }
            }

        }
        return joinPoint.proceed();
    }


    private void startPage() {
        String json = HttpUtils.getJson(request);
        Page page = JSON.parseObject(json, Page.class);
        if (page == null) {
            page = new Page();
            page.setPageNum(1);
            page.setPageNum(10);
            logger.warn("从request 获取到的 page 为空，page将会使用默认值");
        }

        PageHelper.startPage(page.getPageNum(),page.getPageSize(),page.getOrderBy());
    }
}
