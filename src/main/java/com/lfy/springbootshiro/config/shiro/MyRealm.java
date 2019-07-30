package com.lfy.springbootshiro.config.shiro;

import com.lfy.springbootshiro.bean.SysPermission;
import com.lfy.springbootshiro.bean.SysRole;
import com.lfy.springbootshiro.bean.SysUser;
import com.lfy.springbootshiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义 Realm
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取主体的身份
        String username = (String) authenticationToken.getPrincipal();
        System.out.println("---> Principal:"+username);
        //根据用户名查询用户信息
        SysUser existUser = userService.findUserByUserName(username);
        if(existUser == null){
            return null;
        }
        System.out.println("---> DataBase:"+existUser);
        //如果不为空 则构建 SimpleAuthenticationInfo
        //组装 authenticationInfo
        //参数一 : 数据库中的用户 参数二 : 数据库中的密码 参数三 : realm 的 name
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(existUser,existUser.getPassword(),this.getName());
        //返回认证信息到 Controller
        return authenticationInfo;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //访问 @RequirePermission 注解的 url 时触发
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //得到要授权的用户信息
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        //用户角色权限进行绑定
        for(SysRole role : user.getRoleList()) {
            authorizationInfo.addRole(role.getRolename());
            for(SysPermission permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

}
