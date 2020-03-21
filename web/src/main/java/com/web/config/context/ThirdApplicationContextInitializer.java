package com.web.config.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class ThirdApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C>,Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ThirdApplicationContextInitializer- --- ");
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
