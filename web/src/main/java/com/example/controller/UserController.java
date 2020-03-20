package com.example.controller;


import com.example.entity.User;
import com.example.model.UserModel;
import com.example.srv.UserSrv;
import com.example.utils.response.BusinessException;
import com.example.utils.response.CommonReturnType;
import com.example.utils.response.EmBusinessError;
import com.example.vo.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends BaseController {

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


    @RequestMapping("/saveuser")
    public CommonReturnType saveUser(UserVo userVo) {

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userVo, userModel);
        userSrv.saveUser(userModel);
        return CommonReturnType.sendResponse("OK");
    }

    @RequestMapping("/deluser")
    public CommonReturnType delUserById(Integer id) {
        userSrv.delUserById(id);
        return CommonReturnType.sendResponse("OK");
    }

    @RequestMapping("/updateuser")
    public CommonReturnType updateUser(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        userSrv.updateUser(user);
        return CommonReturnType.sendResponse("OK");
    }


    @RequestMapping("/pageuser")
    public CommonReturnType pageUser(@Param("userVo") UserVo userVo,
                           @RequestParam(value = "pageNum",defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",defaultValue="10") int pageSize) {
//        userVo.setPageNum(pageNum);
//        userVo.setPageSize(pageSize);
        PageHelper.startPage(pageNum, pageSize);
        Page<User> userPage = userSrv.selectByPageNumSize(userVo);
        PageInfo<User> userPageInfo = new PageInfo<>(userPage);
        return CommonReturnType.sendResponse(userPageInfo);
    }
}
