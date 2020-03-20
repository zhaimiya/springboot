package com.example.srv.impl;


import com.example.mapper.UserMapper;
import com.example.mapper.UserPasswordMapper;
import com.example.entity.User;
import com.example.entity.UserPassword;
import com.example.model.UserModel;
import com.example.srv.UserSrv;
import com.example.vo.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

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

    @Override
    @Transactional(rollbackFor ={Exception.class,SQLException.class})
    public void saveUser(UserModel userModel){
        User user = new User();
        UserPassword userPassword = new UserPassword();
        BeanUtils.copyProperties(userModel,user);
        BeanUtils.copyProperties(userModel,userPassword);
        userMapper.insert(user);
        userPasswordMapper.insert(userPassword);
    }

    @Override
    @Transactional(rollbackFor ={Exception.class,SQLException.class})
    public void delUserById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
        userPasswordMapper.deleteByUserId(id);
    }

    @Override
    @Transactional(rollbackFor ={Exception.class,SQLException.class})
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }


    @Override
    public Page<User> selectByPageNumSize(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        return (Page<User>)userMapper.selectByPageNumSize(user);
    }
}
