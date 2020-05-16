package com.linkgoo.framework.web.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.linkgoo.framework.web.core.response.Response;
import com.linkgoo.framework.web.core.response.RestResponse;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * CustomerErrorController class
 *
 * @description: 错误控制器
 *
 * @author qixiao.bi
 * @date 2020-01-08 16:17
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomerErrorController extends AbstractErrorController {



    public CustomerErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }



    public String getErrorPath() {
        return null;
    }

    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = Collections
                .unmodifiableMap(getErrorAttributes(request,false));
        response.setStatus(status.value());
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        return (modelAndView != null) ? modelAndView : new ModelAndView("error", model);
    }

    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity<String>(status);
        }
        Map<String, Object> body = getErrorAttributes(request, false);
        Response<Object> res = RestResponse.builder().status((Integer) body.get("status")).msg((String) body.get("error")).build();
        return new ResponseEntity<>(JSONObject.toJSONString(res), status);
    }



}
