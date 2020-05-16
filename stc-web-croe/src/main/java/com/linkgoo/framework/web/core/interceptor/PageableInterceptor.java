package com.linkgoo.framework.web.core.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * PageableInterceptor class
 *
 * @description: 分页拦截
 *
 * @author qixiao.bi
 * @date 2020-01-09 15:00
 */
@Intercepts(
        {
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        }
)
public class PageableInterceptor implements Interceptor {


    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        //执行请求方法，并将所得结果保存到result中
        Object result = invocation.proceed();
        if (result instanceof com.github.pagehelper.Page) {
            Page page = new Page<>();
            BeanUtils.copyProperties(page,result);
            page.setRes((com.github.pagehelper.Page)result);
            ArrayList<Object> res = new ArrayList<>();
            res.add(page);
            return res;
        }
        return result;
    }

}
