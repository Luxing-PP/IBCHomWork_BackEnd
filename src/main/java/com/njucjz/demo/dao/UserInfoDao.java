package com.njucjz.demo.dao;

import com.njucjz.demo.data.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao {

    // 初始化
    boolean create(UserInfo userInfo);

    //根据uid version返回info
    UserInfo getUserInfoByUid(Integer uid, Integer version);

    boolean updateLetterCountByUid(Integer uid, Integer version, Integer letterCount);
    boolean increaseLoginDayByUid(Integer uid, Integer version);
    boolean increaseSaveTimesByUid(Integer uid, Integer version, Integer extendTime);
}
