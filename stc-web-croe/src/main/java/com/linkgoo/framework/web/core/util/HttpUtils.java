package com.linkgoo.framework.web.core.util;

import com.alibaba.fastjson.JSONObject;
import com.linkgoo.framework.web.core.LinkgooHttpServletRequestWrapper;
import com.linkgoo.framework.web.core.response.RestResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * HttpUtils class
 *
 * 获取json
 *
 * @author qixiao.bi
 * @date 2019-03-27   23:48
 */
public class HttpUtils {

    /**
     * 获取json
     * @param request
     * @return string
     * @date  2019-03-27   23:48
     **/
    public static String getJson(HttpServletRequest request) {
        if (request instanceof LinkgooHttpServletRequestWrapper) {
            LinkgooHttpServletRequestWrapper requestWrapper = (LinkgooHttpServletRequestWrapper) request;
            return requestWrapper.getBody();
        }else{
            try {
                throw new Exception("request 不是 HttpServletRequestWrapper ,不允许读取request 的 json 数据");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <DATA> void  success(HttpServletResponse response,DATA data) throws IOException {
        responseSetting(response);
        response.getWriter().write(JSONObject.toJSONString(RestResponse.success("ok",data)));
    }

    public static void  fail(HttpServletResponse response,String msg) throws IOException {
        responseSetting(response);
        response.getWriter().write(JSONObject.toJSONString(RestResponse.fail(msg)));
    }

    public static void responseSetting(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        // 允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许自定义请求头token(允许head跨域)
        response.setHeader("Access-Control-Allow-Headers",
                "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
    }

    public static void  restResponse(HttpServletResponse response,RestResponse restResponse) throws IOException {
        responseSetting(response);
        response.getWriter().write(JSONObject.toJSONString(restResponse));
    }
}
