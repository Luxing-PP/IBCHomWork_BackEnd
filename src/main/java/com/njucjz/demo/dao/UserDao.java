package com.njucjz.demo.dao;

import com.njucjz.demo.data.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    boolean save(User user);

    User getUserByOpenid(String openid);

    List<User> selectAll();

    int getActiveUserAmount();
    //全部改为不活跃
    boolean resetAll();

    //tip 顺便更新了isActive
    boolean updateLoginTimeByUid(Integer uid);
}
