package com.njucjz.demo.controller;


import com.njucjz.demo.data.User;
import com.njucjz.demo.form.GetInfoForm;
import com.njucjz.demo.form.LoginForm;
import com.njucjz.demo.form.UserForm;
import com.njucjz.demo.service.UserInfoService;
import com.njucjz.demo.service.UserService;
import com.njucjz.demo.vo.UserInfoVO;
import com.njucjz.demo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//路由映射， /user 的连接会映射到下属方法
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/getInfo")
    public UserInfoVO getInfo(@RequestBody GetInfoForm getInfoForm){
        System.out.println(getInfoForm.toString());
        return  userInfoService.getUserInfo(getInfoForm.getUid(),getInfoForm.getVersion());
    }

    @PostMapping("/register")
    public boolean register(@RequestBody UserForm userForm){
        System.out.println(userForm.toString());
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userService.save(user);
    }

    @PostMapping("/login")
    public UserVO login(@RequestBody LoginForm loginForm){
        System.out.println(loginForm.toString());
        return  userService.login(loginForm.getUsername(), loginForm.getPassword());
    }
}
