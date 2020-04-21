package com.example.springbootrest.config;

import com.example.springbootrest.utils.PropertiesHandlerMethodArgumentResolver;
import com.example.springbootrest.utils.PropertiesHttpMsgConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    //    由于built-in在自定义之前，
    @PostConstruct
    public void init() {
        // 获取所有的ArgumentResolvers
        List<HandlerMethodArgumentResolver> resolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> curResolvers = new ArrayList<>(resolvers.size() + 1);
        // 放在首位
        curResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        curResolvers.addAll(resolvers);
        // 重新设置Resolver集合
        requestMappingHandlerAdapter.setArgumentResolvers(curResolvers);

    }

    /**
     * Add resolvers to support custom controller method argument types.
     * <p>This does not override the built-in support for resolving handler
     * method arguments. To customize the built-in support for argument
     * resolution, configure {@link RequestMappingHandlerAdapter} directly.
     *
     * @param resolvers initially an empty list
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.set(0, new PropertiesHttpMsgConvert());
    }
}
