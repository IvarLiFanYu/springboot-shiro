package com.lfy.springbootshiro.bean;

import java.util.List;

/**
 * 角色类
 */
public class SysRole {

    private int id;
    private String rolename;//角色名称
    private String roledesc;//角色描述

    //一个角色对应多个权限
    private List<SysPermission> permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}

