package com.njucjz.demo.service;

import com.njucjz.demo.data.User;
import com.njucjz.demo.vo.UserVO;

public interface UserService {
    /*用户注册*/
    User save(User user);

    UserVO login(String code);
}
