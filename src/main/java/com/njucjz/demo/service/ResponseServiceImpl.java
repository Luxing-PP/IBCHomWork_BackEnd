package com.njucjz.demo.service;

import com.njucjz.demo.dao.ResponseDao;
import com.njucjz.demo.dao.UserInfoDao;
import com.njucjz.demo.dao.UserLetterDao;
import com.njucjz.demo.data.Response;
import com.njucjz.demo.data.User;
import com.njucjz.demo.data.UserInfo;
import com.njucjz.demo.data.UserLetter;
import com.njucjz.demo.util.TimerInstance;
import com.njucjz.demo.vo.ResponseVO;
import com.njucjz.demo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService{
    @Autowired
    ResponseDao responseDao;

    @Autowired
    UserLetterDao userLetterDao;

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public boolean writeResponse(Response response) {
        boolean resultOfResponse = false;
        boolean resultOfUserLetter =false;
        try{
            resultOfResponse = responseDao.save(response);
            if(resultOfResponse){
                //更新信件池
                UserLetter userLetter = new UserLetter();
                userLetter.setUid(response.getUid());
                userLetter.setLid(response.getLid());

                resultOfUserLetter = userLetterDao.save(userLetter);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        //2. 增加时长
        int extendTime = TimerInstance.extendLifeTo12H();
        boolean resultOfInfo = userInfoDao.increaseSaveTimesByUid(response.getUid(),TimerInstance.version,extendTime);

        return resultOfResponse&&resultOfUserLetter&&resultOfInfo;
    }

    @Override
    public List<ResponseVO> getResponseByLid(Integer uid,Integer lid) {
        boolean isNeedRefresh = false;
        List<Response> responses = responseDao.getResponseByLid(lid);
        List<ResponseVO> result = new ArrayList<>();
        for(Response rs:responses){
            if(uid == rs.getUid()){
                isNeedRefresh = true;
            }
            ResponseVO rsVO = new ResponseVO();
            BeanUtils.copyProperties(rs,rsVO);
            result.add(rsVO);
        }

        //如果用户参与了那么更新信件池
        if(isNeedRefresh){
            userLetterDao.deleteLetter(uid,lid);
        }
        return result;
    }
}
