package com.example.springbootrest.utils;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return Properties.class.equals(methodParameter.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {

        Properties properties = (Properties) o;

        // NativeWebRequest-->HttpServletRequest
        ServletWebRequest servletWebRequest = (ServletWebRequest) nativeWebRequest;
        HttpServletRequest httpServletRequest = servletWebRequest.getRequest();


        // 获取到MediaType
        String contentType = httpServletRequest.getHeader("Content-Type");
        MediaType mediaType = MediaType.parseMediaType(contentType);


        HttpServletResponse httpServletResponse = servletWebRequest.getNativeResponse(HttpServletResponse.class);
        HttpOutputMessage httpOutputMessage = new ServletServerHttpResponse(httpServletResponse);

        PropertiesHttpMsgConvert propertiesHttpMsgConvert = new PropertiesHttpMsgConvert();

        propertiesHttpMsgConvert.write(properties, mediaType, httpOutputMessage);

        // 通知Web WVC当前请求已经处理完毕
        modelAndViewContainer.setRequestHandled(true);
    }
}
