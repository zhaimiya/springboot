package com.web.config.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE)
public class FirstApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("FirstApplicationListener--");
    }
}
