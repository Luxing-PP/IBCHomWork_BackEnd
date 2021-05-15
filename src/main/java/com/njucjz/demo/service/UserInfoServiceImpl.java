package com.njucjz.demo.service;

import com.njucjz.demo.dao.UserInfoDao;
import com.njucjz.demo.data.UserInfo;
import com.njucjz.demo.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfoVO getUserInfo(Integer uid, Integer version) {
        UserInfo userInfo = userInfoDao.getUserInfoByUid(uid,version);
        if(userInfo==null){
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        //todo 加入count
        userInfoVO.setSaveTimes(userInfo.getSaveTimes());
        userInfoVO.setLoginDay(userInfo.getLoginDay());
        userInfoVO.setLetterCount(1);

        return userInfoVO;
    }
}
