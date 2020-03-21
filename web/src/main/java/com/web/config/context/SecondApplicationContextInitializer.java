package com.web.config.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@Order(999)
public class SecondApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("SecondApplicationContextInitializer- --- ");
    }
}
