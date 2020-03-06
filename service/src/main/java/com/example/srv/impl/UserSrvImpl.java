package com.example.srv.impl;


import com.example.mapper.UserMapper;
import com.example.mapper.UserPasswordMapper;
import com.example.entity.User;
import com.example.entity.UserPassword;
import com.example.model.UserModel;
import com.example.srv.UserSrv;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSrvImpl implements UserSrv {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private UserPasswordMapper userPasswordMapper;

    @Override
    public UserModel queryUserById(Integer id) {
        User user= userMapper.selectByPrimaryKey(id);
        if (null == user)
            return null;
        UserPassword userPassword = userPasswordMapper.selectByUserId(id);
        return convertFromDataObject(user,userPassword);
    }

    private UserModel convertFromDataObject(User user, UserPassword userPassword){
        UserModel userModel = new UserModel();
        if(null!=user)
        BeanUtils.copyProperties(user,userModel);
        if(null!=userPassword)
            userModel.setPassword(userPassword.getUserPassword());
        return userModel;
    }

}
