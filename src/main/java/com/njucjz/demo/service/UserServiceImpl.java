package com.njucjz.demo.service;

import com.njucjz.demo.dao.UserDao;
import com.njucjz.demo.data.User;
import com.njucjz.demo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public boolean save(User user) {
        boolean result = false;
        try{
            result = userDao.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }

    @Override
    public UserVO login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return userVO;
    }
}
