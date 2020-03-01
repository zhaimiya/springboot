package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        // 完全禁用重启
       //System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(SpringbootApplication.class, args);
        System.out.printf("hello world");
    }

}
