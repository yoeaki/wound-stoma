package com.linkgoo.framework.utils.generation.builder;

import com.linkgoo.framework.utils.generation.model.Table;
import com.linkgoo.framework.utils.generation.config.Config;
import freemarker.template.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CodeBuilder class
 *
 * @description: 代码构建器
 *
 * @author qixiao.bi
 * @date 2020-01-07  15:44
 */
public interface CodeBuilder {

    Logger logger = LoggerFactory.getLogger(CodeBuilder.class);

    Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);

    void builder(Config config, Table table) ;
}
