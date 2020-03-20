package com.example.srv;

import com.example.entity.User;
import com.example.model.UserModel;
import com.example.vo.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface UserSrv {
    UserModel queryUserById(Integer id);
    void saveUser(UserModel user);
    void delUserById(Integer id);
    void updateUser(User user);
    Page<User> selectByPageNumSize(UserVo userVo);
}
