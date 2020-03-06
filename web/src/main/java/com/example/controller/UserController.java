package com.example.controller;

import com.example.model.UserModel;
import com.example.srv.UserSrv;
import com.example.utils.response.BusinessException;
import com.example.utils.response.CommonReturnType;
import com.example.utils.response.EmBusinessError;
import com.example.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserSrv userSrv;

    @RequestMapping("/getuser")
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userSrv.queryUserById(id);
        if (null == userModel)
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        System.out.println(userModel.toString());
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel, userVo);
        return CommonReturnType.sendResponse(userVo);
    }

    @RequestMapping
    public String test() {
        return "hello-- --";
    }
}
