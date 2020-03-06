package com.example.controller;

import com.example.model.UserModel;
import com.example.srv.UserSrv;
import com.example.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserSrv userSrv;

    @RequestMapping("/getuser")
    public UserVo getUser(@RequestParam(name = "id") Integer id) {
        UserModel userModel = userSrv.queryUserById(id);
        System.out.println(userModel.toString());
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel,userVo);
        return userVo;
    }


    @RequestMapping
    public String test(){
        return "hello-- --";
    }
}
