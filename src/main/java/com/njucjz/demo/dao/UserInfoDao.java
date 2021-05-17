package com.njucjz.demo.dao;

import com.njucjz.demo.data.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao {

    //todo 用于初始化 , 未测试
    boolean save(UserInfo userInfo);

    //根据uid version返回info
    UserInfo getUserInfoByUid(Integer uid, Integer version);
}
