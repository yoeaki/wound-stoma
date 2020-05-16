package com.linkgoo.framework.web.core.exception.resolver;



import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.linkgoo.framework.web.core.exception.*;
import com.linkgoo.framework.web.core.response.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;
import java.util.Map;

/**
 * @author biqixiao
 * @description: 全局异常解析器
**/
@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        ex.printStackTrace();
        RestResponse restResponse = null;
        //参数异常
        if (ex instanceof ValidationException || ex instanceof ParamException) {
            restResponse = RestResponse.paramError(ex.getMessage());
            logger.info("ValidationException: "+ex.getMessage());
        }
        //应用异常
        if (ex instanceof AppException) {
            restResponse = RestResponse.fail(ex.getMessage());
            logger.info("AppException: "+ex.getMessage());
        }
        //系统异常
        if (ex instanceof SysException) {
            restResponse = RestResponse.systemError(ex.getMessage());
            logger.info("SysException: "+ex.getMessage());
        }
        //操作异常
        if(ex instanceof OperationException){
            restResponse = RestResponse.operationError(ex.getMessage());
            logger.info("OperationException: "+ex.getMessage());
        }
        //登入异常
        if(ex instanceof LoginException){
            restResponse = RestResponse.notLogger(ex.getMessage());
            logger.info("LoginException: "+ex.getMessage());
        }
        //业务异常
        if(ex instanceof BusinessException){
            restResponse = RestResponse.systemError(ex.getMessage());
            logger.info("BusinessException: "+ex.getMessage());
        }
        if (null==restResponse) {
            restResponse = RestResponse.unknownError(ex.getMessage());
            logger.info("其他未知异常: "+ex.getMessage());
        }

        //将bean转换为json 输出
        Map map = JSONObject.parseObject(JSONObject.toJSONString(restResponse), Map.class);
        FastJsonJsonView fastJsonJsonView = new FastJsonJsonView();
        fastJsonJsonView.setAttributesMap(map);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(fastJsonJsonView);
        return modelAndView;
    }
}
