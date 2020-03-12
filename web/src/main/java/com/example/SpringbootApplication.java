package com.example;

import com.example.config.context.FirstApplicationContextInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan(value = {"com.example.mapper"})
@ServletComponentScan("com.example.servlet")
public class SpringbootApplication {


    public static void main(String[] args) {

        System.out.println(" -- hello --");
        // 完全禁用重启
        //System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication application = new SpringApplication(SpringbootApplication.class);
        application.addInitializers(new FirstApplicationContextInitializer());
        application.run(args);
        System.out.printf(" -- world --");


//        new SpringApplicationBuilder(SpringbootApplication.class)
//                .initializers(new FirstApplicationContextInitializer())
//                .run(args);

    }

}
