package com.example.springbootrest.utils;

        import org.springframework.core.MethodParameter;
        import org.springframework.http.MediaType;
        import org.springframework.web.bind.support.WebDataBinderFactory;
        import org.springframework.web.context.request.NativeWebRequest;
        import org.springframework.web.context.request.ServletWebRequest;
        import org.springframework.web.method.support.HandlerMethodArgumentResolver;
        import org.springframework.web.method.support.ModelAndViewContainer;

        import javax.servlet.http.HttpServletRequest;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.nio.charset.Charset;
        import java.util.Properties;

public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    // 是否解析
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Properties.class.equals(methodParameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // NativeWebRequest-->HttpServletRequest
        ServletWebRequest servletWebRequest = (ServletWebRequest) nativeWebRequest;
        HttpServletRequest httpServletRequest = servletWebRequest.getRequest();


        // 获取到Charset
        String contentType = httpServletRequest.getHeader("Content-Type");
        MediaType mediaType = MediaType.parseMediaType(contentType);
        Charset charset = mediaType.getCharset();
        charset = null == charset ? Charset.forName("UTF-8") : charset;

        //从httpServletRequest中得到InputStreamReader
        InputStream inputStream = httpServletRequest.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);


        // 加载字符输入流weiProperties
        Properties properties = new Properties();
        properties.load(inputStreamReader);
        return properties;
    }
}
