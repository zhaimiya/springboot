package com.service.srv;

import com.dataobject.entity.User;
import com.dataobject.model.UserModel;
import com.dataobject.vo.UserVo;
import com.github.pagehelper.Page;


public interface UserSrv {
    UserModel queryUserById(Integer id);
    void saveUser(UserModel user);
    void delUserById(Integer id);
    void updateUser(User user);
    Page<User> selectByPageNumSize(UserVo userVo);
}
