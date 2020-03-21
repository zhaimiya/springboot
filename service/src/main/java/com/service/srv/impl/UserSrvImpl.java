package com.service.srv.impl;


import com.dao.mapper.UserMapper;
import com.dao.mapper.UserPasswordMapper;
import com.dataobject.entity.User;
import com.dataobject.entity.UserPassword;
import com.dataobject.model.UserModel;
import com.service.srv.UserSrv;
import com.dataobject.vo.UserVo;
import com.github.pagehelper.Page;
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
