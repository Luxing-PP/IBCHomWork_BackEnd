package com.njucjz.demo.service;

import com.njucjz.demo.data.User;
import com.njucjz.demo.vo.UserVO;

public interface UserService {
    /*用户注册*/
    boolean save(User user);

    UserVO login(String username, String password);
}
