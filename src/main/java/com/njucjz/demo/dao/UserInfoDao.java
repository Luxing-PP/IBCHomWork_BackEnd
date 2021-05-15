package com.njucjz.demo.dao;

import com.njucjz.demo.data.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao {

//    根据uid version返回info
    UserInfo getUserInfoByUid(Integer uid, Integer version);
}
