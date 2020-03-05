package com.example.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
/**
 * 项目启动时候运行
 * Ordered越小越优先执行
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner, Ordered {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner.run()-- -- --- ");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
