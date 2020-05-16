package com.linkgoo.framework.web.core.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.linkgoo.framework.web.core.util.BeanValidator;
import com.linkgoo.framework.web.core.util.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * ValidatedInterceptor class
 *
 * @description: 参数验证拦截器，用于判断403错误，以友好的方式抛出具体的错误，方便前端调整
 *
 * @author qixiao.bi
 * @date 2020-01-09 15:01
 */
public class ValidatedInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod)handler;
            MethodParameter[] methodParameters = h.getMethodParameters();
            for (MethodParameter mp : methodParameters) {
                if (mp.getParameterAnnotation(Valid.class) != null||mp.getParameterAnnotation(Validated.class) != null) {
                    Object o = null;
                    String json = HttpUtils.getJson(request);
                    if (StringUtils.isBlank(json)) {
                        o = mp.getParameterType().newInstance();
                    }else{
                        o = JSONObject.parseObject(json, mp.getParameterType());
                    }
                    BeanValidator.validate(o);
                }
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
