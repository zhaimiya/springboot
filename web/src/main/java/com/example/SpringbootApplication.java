package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.example.mapper","com.example.controller","com.example.srv"})

@MapperScan(value = {"com.example.mapper"})
public class SpringbootApplication {


    public static void main(String[] args) {
        // 完全禁用重启
        System.out.println(" -- hello --");
        //System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(SpringbootApplication.class, args);
        System.out.printf(" -- world --");
    }

}
