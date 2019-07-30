package com.lfy.springbootshiro.controller;

import com.lfy.springbootshiro.bean.SysUser;
import com.lfy.springbootshiro.service.IUserService;
import com.lfy.springbootshiro.service.UserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/","/index"})
    //@ResponseBody
    public String root(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, String> map) {
        System.out.println("login ... ");
        String exception = (String)request.getAttribute("shiroLoginFailure");
        System.out.println("exception"+ exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "unknownAccount";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "incorrectPassword";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);

        //认证成功由shiro框架自行处理
        return "login";
    }

    @GetMapping("/user/{username}")
    @ResponseBody
    @RequiresPermissions("/product/add")
    public SysUser findUserByName(@PathVariable("username") String username){
        SysUser user = userService.findUserByUserName(username);
        return user;
    }

}
