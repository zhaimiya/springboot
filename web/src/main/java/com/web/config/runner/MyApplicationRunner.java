package com.web.config.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 项目启动时候运行
 */
@Component
public class MyApplicationRunner implements ApplicationRunner, Ordered {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner.run()-- -- ----");
    }


    @Override
    public int getOrder() {
        return 10;
    }
}
