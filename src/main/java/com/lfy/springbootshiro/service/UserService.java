package com.lfy.springbootshiro.service;

import com.lfy.springbootshiro.bean.SysUser;
import com.lfy.springbootshiro.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser findUserByUserName(String username) {
        return userMapper.findByUserName(username);
    }
}
