package com.lfy.springbootshiro.bean;

import java.util.List;

/**
 * 用户类
 * @author 15099
 *
 */
public class SysUser {

    private int id;
    private String username;
    private String password;

    // 一个用户有多个角色
    private List<SysRole> roleList;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
