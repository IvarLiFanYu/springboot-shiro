package com.lfy.springbootshiro.bean;

import java.util.List;

public class SysPermission {

        private int id;
        private String modelname;
        private String permission;

        //一个权限可以被多个角色拥有
        //角色(*) -- 权限(*)
        private List<SysRole> roles;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getModelname() {
            return modelname;
        }

        public void setModelname(String modelname) {
            this.modelname = modelname;
        }

        public String getPermission() {
            return permission;
        }

        public void setPermission(String permission) {
            this.permission = permission;
        }

        public List<SysRole> getRoles() {
            return roles;
        }

        public void setRoles(List<SysRole> roles) {
            this.roles = roles;
        }
}

