package com.linkgoo.framework.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Application class
 *
 * @description: 入口
 *
 * @author qixiao.bi
 * @date 2020-01-08 10:46
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@MapperScan("com.linkgoo.framework.web.repository.*")
public class  Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}