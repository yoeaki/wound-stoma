package com.linkgoo.framework.web.core.response;

import org.apache.commons.lang3.StringUtils;

public class RestResponse<DATA> extends Response<DATA> {

    /**成功*/
    private final static Integer SUCCESS = 0;
    /**失败*/
    private final static Integer FAIL = 1;
    /**参数错*/
    private final static Integer PARAM_ERROR = 2;
    /**操作错误*/
    private final static Integer OPERATION_ERROR = 3;
    /**未知错误*/
    private final static Integer UNKNOWN_ERROR = 4;
    /**系统错误*/
    private final static Integer SYSTEM_ERROR = 5;
    /**未登入*/
    private final static Integer NOT_LOGGED = 401;

    public static <DATA> RestResponse success(String msg,DATA data) {
        return output(SUCCESS,msg,data);
    }
    public static <DATA> RestResponse success(DATA data) {
        return output(SUCCESS,null,data);
    }
    public static RestResponse success(String msg) {
        return output(SUCCESS,msg,null);
    }
    public static RestResponse success() {
        return output(SUCCESS,null,null);
    }
    public static <DATA>  RestResponse output(Integer status,String msg,DATA data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setData(data);
        restResponse.setMsg(msg);
        restResponse.setStatus(status);
        return restResponse;
    }
    public static  RestResponse fail(String msg) {
        return error(FAIL,msg);
    }
    public static  RestResponse paramError(String msg) {
        return error(PARAM_ERROR,msg);
    }
    public static  RestResponse operationError(String msg) {
        return error(OPERATION_ERROR,msg);
    }
    public static  RestResponse unknownError(String msg) {
        return error(UNKNOWN_ERROR,msg);
    }
    public static  RestResponse systemError(String msg) {
        return error(SYSTEM_ERROR,msg);
    }
    public static  RestResponse notLogger(String msg) {
        return error(NOT_LOGGED,msg);
    }
    private static RestResponse error(Integer status,String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setMsg(StringUtils.isBlank(msg)?"fail":msg);
        restResponse.setStatus(status);
        return restResponse;
    }



}
