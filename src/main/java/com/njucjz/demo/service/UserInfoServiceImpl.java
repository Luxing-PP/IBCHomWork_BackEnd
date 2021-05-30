package com.njucjz.demo.service;

import com.njucjz.demo.dao.LetterDao;
import com.njucjz.demo.dao.UserInfoDao;
import com.njucjz.demo.data.UserInfo;
import com.njucjz.demo.util.TimerInstance;
import com.njucjz.demo.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    LetterDao letterDao;

    @Override
    public UserInfoVO getUserInfo(Integer uid, Integer version) {
        UserInfo userInfo = userInfoDao.getUserInfoByUid(uid,version);
        if(userInfo==null){
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userInfo,userInfoVO);

        if(version== TimerInstance.version){
            userInfoVO.setLetterCount(letterDao.getLetterCountByUid(uid));
        }

        return userInfoVO;
    }
}
