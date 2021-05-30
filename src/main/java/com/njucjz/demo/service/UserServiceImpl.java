package com.njucjz.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.njucjz.demo.dao.UserDao;
import com.njucjz.demo.dao.UserInfoDao;
import com.njucjz.demo.data.User;
import com.njucjz.demo.data.UserInfo;
import com.njucjz.demo.util.DateUtil;
import com.njucjz.demo.util.TimerInstance;
import com.njucjz.demo.util.WxAPIHelper;
import com.njucjz.demo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public User save(User user) {
        boolean result = false;
        try{
            result = userDao.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        //注册成功就顺便注册基本信息，PS：此时双向绑定 user.uid已经有了
        if(result){
            userInfoDao.create(new UserInfo(user.getUid(),TimerInstance.version));
        }

        return user;
    }

    @Override
    public UserVO login(String code) {
        System.out.println("code" + code);
        String openid = "";
        if(code.equals("404404")){
            //tip 调试用
            openid = "404404";
        }else {
            String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                    "appid=wx14be6572bd0f0e98" +
                    "&secret=35b9a5a241664f601c33bf06e6dacef7" +
                    "&js_code=" + code +
                    "&grant_type=authorization_code";

            openid = WxAPIHelper.getOpenid(url);
            if (openid==null){
                UserVO error = new UserVO();
                error.setOpenid("Error!!!! 联系一下我");
                return error;
            }else if(openid.equals("40163")){
                UserVO error = new UserVO();
                error.setOpenid("微信服务端Error: errorCode=40163，重复使用了同一个码");
                return error;
            }else {
                UserVO error = new UserVO();
                error.setOpenid("Error!!!! 联系一下我,微信API errorCode="+openid);
                return error;
            }
        }

        User user = userDao.getUserByOpenid(openid);
        if (user == null){
            // 未注册
            user = register(openid);
        }

        //是否是新一天，并更新登录时间/Active状态
        boolean isNewDay = DateUtil.isNewDay(user.getLoginTime());
        userDao.updateLoginTimeByUid(user.getUid());

        if(isNewDay){
            //新一天，更新userInfo
            boolean isOK = userInfoDao.increaseLoginDayByUid(user.getUid(), TimerInstance.version);
        }else {
            //do nothing
        }

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        userVO.setNewDay(isNewDay);

        return userVO;
    }

    private User register(String openid){
        User user = new User();
        user.setOpenid(openid);
        return save(user);
    }
}
