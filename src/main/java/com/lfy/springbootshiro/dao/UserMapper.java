package com.lfy.springbootshiro.dao;

import com.lfy.springbootshiro.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //根据用户名查询用户信息
    SysUser findByUserName(String username);
}
