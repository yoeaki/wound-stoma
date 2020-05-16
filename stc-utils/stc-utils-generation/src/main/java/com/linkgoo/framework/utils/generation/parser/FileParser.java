package com.linkgoo.framework.utils.generation.parser;

import com.linkgoo.framework.utils.generation.model.Table;
import com.linkgoo.framework.utils.generation.config.Config;
import com.linkgoo.framework.utils.generation.model.Column;
import com.linkgoo.framework.utils.generation.utils.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileParser {

    static public Table parserFile(Config config) throws Exception {
        if (!FileUtil.fileExists(config.getInputFilePath())) {
            throw new Exception("找不到输入文件："+config.getInputFilePath());
        }
        List<String> content = FileUtils.readLines(new File(config.getInputFilePath()), config.getInputFileCharacterCoding());
        if (content.size() == 0) {
            throw new Exception("请检查文件内容");
        }
        Table table = new Table();
        //前缀
        table.setPrefix(config.getTablePrefix());
        TableParser.parseTableName(table,content.get(0).replace(" ",""));
        List<Column> columns = TableParser.parseColumn(content.subList(1, content.size()), config.dialect());
        table.setColumns(columns);
        table.setPk(columns.stream().filter(Column::isPk).collect(Collectors.toList()));
        table.setPlainColumns(columns.stream().filter(e->!e.isPk()).collect(Collectors.toList()));
        return table;
    }

}
