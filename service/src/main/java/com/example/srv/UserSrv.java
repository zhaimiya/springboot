package com.example.srv;

import com.example.entity.User;
import com.example.model.UserModel;
import org.springframework.stereotype.Service;


public interface UserSrv {
    UserModel queryUserById(Integer id);
}
