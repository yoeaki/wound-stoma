package com.linkgoo.framework.web.core;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * LinkgooHttpServletRequestWrapper class
 *
 * @description: request包装
 *
 * @author qixiao.bi
 * @date 2020-01-09 15:08
 */
public class LinkgooHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final String body;

    /**
     * @description: 实例过程中读取body
     * @param:
     * @returns:
     * @create: 2019-03-28   00:02
    **/
    public LinkgooHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = request.getInputStream();

        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] chunk = new char[128];
            int bytesRead;
            while ((bytesRead = bufferedReader.read(chunk)) > 0) {
                stringBuilder.append(chunk, 0, bytesRead);
            }
        }

        body = stringBuilder.toString();
    }

    /**
     * 重新getInputStream，缓存Body数据
     *
     * @return
     * @throws IOException
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());

        ServletInputStream servletInputStream = new ServletInputStream() {

            @Override
            public int read() throws IOException { return byteArrayInputStream.read(); }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {}

        };

        return servletInputStream;
    }

    /**
     * 读取缓存数据
     *
     * @return
     * @throws IOException
     */
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    /**
     * @description: 获取body
     * @param:
     * @returns:
     * @author: qixiao.bi
     * @create: 2019-03-27   23:51
    **/
    public String getBody() {
        return this.body;
    }

}

