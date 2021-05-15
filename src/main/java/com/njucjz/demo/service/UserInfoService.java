package com.njucjz.demo.service;

import com.njucjz.demo.vo.UserInfoVO;

public interface UserInfoService {
    //获取用户信息
    UserInfoVO getUserInfo(Integer uid, Integer version);
}
