package com;

import com.web.config.context.FirstApplicationContextInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.web.controller","com.web.config.i18n","com.service.srv.impl"})
@MapperScan(value = {"com.dao.mapper"})
@ServletComponentScan("com.servlet") // 异步非阻塞
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
