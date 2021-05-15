package com.njucjz.demo.dao;

import com.njucjz.demo.data.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    boolean save(User user);

    User getUserByUsername(String username);
}
