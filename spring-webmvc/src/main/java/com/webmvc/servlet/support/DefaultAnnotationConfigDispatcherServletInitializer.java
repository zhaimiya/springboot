package com.webmvc.servlet.support;

import com.webmvc.configuration.DispatcherServletConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class
DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 对应web.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // DispatcherServlet
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherServletConfig.class};
    }

    // 映射
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
