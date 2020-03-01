package com.example.controller;

import com.example.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/getuser")
    public User getUser() {
        User user = new User();
        user.setGender(0);
        user.setName("XI");
        return user;
    }
}
