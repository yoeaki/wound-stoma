package com.linkgoo.framework.web.core.filter;

import com.linkgoo.framework.web.core.LinkgooHttpServletRequestWrapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * RequestFilter class
 *
 * @description: 字符设置 ，文件上传过滤
 *
 * @author qixiao.bi
 * @date 2020-01-07  10:39
 */
@Component
@Order(10)
@WebFilter(urlPatterns = "/api/*", filterName = "requestFilter")
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //需要fileupload 的jar包
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                httpServletRequest.getSession().getServletContext());

        //过滤掉文件上传
        if (multipartResolver.isMultipart((HttpServletRequest) request)) {
            chain.doFilter(request, response);
        }else{
            LinkgooHttpServletRequestWrapper requestWrapper = new LinkgooHttpServletRequestWrapper((HttpServletRequest) request);
            //传入Wrapper对象
            chain.doFilter(requestWrapper, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
