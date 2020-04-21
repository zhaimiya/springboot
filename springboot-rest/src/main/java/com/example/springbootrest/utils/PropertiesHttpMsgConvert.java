package com.example.springbootrest.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesHttpMsgConvert extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMsgConvert() {
        //设置支持的MediaType
        super(new MediaType("text", "properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        //获取请求头的ContentType的编码
        HttpHeaders httpHeaders = httpOutputMessage.getHeaders();
        MediaType mediaType = httpHeaders.getContentType();
        Charset charset = null == mediaType.getCharset() ? Charset.forName("UTF-8") : mediaType.getCharset();

        OutputStream outputStream = httpOutputMessage.getBody();
        Writer writer = new OutputStreamWriter(outputStream, charset);

        //properties写入到字符输出流
        properties.store(writer,"From PropertiesHttpMsgConvert#writeInternal");

    }

    @Override
    protected Properties readInternal(Class<? extends Properties> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {


        //获取请求头的ContentType的编码
        HttpHeaders httpHeaders = httpInputMessage.getHeaders();
        MediaType mediaType = httpHeaders.getContentType();
        Charset charset = null == mediaType.getCharset() ? Charset.forName("UTF-8") : mediaType.getCharset();

        // 获取字符流
        InputStream inputStream = httpInputMessage.getBody();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);

        Properties properties = new Properties();
        properties.load(inputStreamReader);
        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, httpInputMessage);
    }
}
