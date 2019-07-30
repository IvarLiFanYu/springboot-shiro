package com.lfy.springbootshiro.service;

import com.lfy.springbootshiro.bean.SysUser;

public interface IUserService {
    SysUser findUserByUserName(String username);
}
