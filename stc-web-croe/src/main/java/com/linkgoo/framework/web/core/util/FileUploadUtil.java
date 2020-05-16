package com.linkgoo.framework.web.core.util;



import com.linkgoo.framework.web.core.exception.ParamException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUploadUtil {

    static public Boolean imgTypeForName(String fileName,String... imgType)throws Exception{
        String[] strings = fileName.split("\\.");
        if (strings.length==0 || strings==null){
            throw new ParamException("fileName：该文件名理应带后缀");
        }
        return containFileType(strings[strings.length-1],imgType);

    }
    static public Boolean containFileType(String fileType,String... types){
        for (String type : types) {
            if (type.equals(fileType)) {
                return true;
            }
        }
        return false;
    }

    static public String getCacheFileName(String fileName) {
        String[] strings = fileName.split("\\.");
        String suffix;
        if (strings.length==0||strings==null){
            return SHA256Util.getSHA256StrJava(fileName+System.currentTimeMillis());
        }
        suffix = strings[strings.length-1];
        return SHA256Util.getSHA256StrJava(fileName+System.currentTimeMillis())+"."+suffix;
    }


    public static String readToString(InputStream is) throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
        return buffer.toString();
    }
}
