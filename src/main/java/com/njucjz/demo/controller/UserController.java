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


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


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
        return  userInfoService.getUserInfo(getInfoForm.getUid(),getInfoForm.getVersion());
    }

    @PostMapping("/login")
    public UserVO login(@RequestParam(name = "code") String code){
        return userService.login(code);
    }
}
