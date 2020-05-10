package com.example.springbootrest.controller;

import com.example.springbootrest.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

//@RestController
@Controller
@RequestMapping("/rest")
public class HelloController {

    @RequestMapping(value = "/hi",
            consumes = "application/*;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    public String hi(@RequestParam(required = false) String msg) {
        return "Hello -~" + msg;
    }

    @PostMapping(value = "/props",
            consumes = "text/properties;charset=UTF-8",
            produces = "text/properties;charset=UTF-8")
    public Properties prop(@RequestBody Properties prop) {
        return prop;
    }

    @PostMapping(value = "/propwithout",
            consumes = "text/properties;charset=UTF-8")
    public Properties propWithout(Properties prop) {
        return prop;
    }

    @PostMapping("/user")
    public User user(@RequestBody User user) {
        return user;
    }

}
