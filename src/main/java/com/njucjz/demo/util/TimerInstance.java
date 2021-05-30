package com.njucjz.demo.util;

import com.njucjz.demo.dao.*;
import com.njucjz.demo.data.Timer;
import com.njucjz.demo.data.User;
import com.njucjz.demo.data.UserInfo;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("TimerInstance")
public class TimerInstance {
    //Constant
    public static int ONE_DAY_SECOND = 86400;
    public static int HALF_DAY_SECOND =43200;
    //DaoList
    private static TimerDao timerDao;
    private static LetterDao letterDao;
    private static UserLetterDao userLetterDao;
    private static UserDao userDao;
    private static ResponseDao responseDao;
    private static UserInfoDao userInfoDao;

    public static int TIMER_INITIAL = ONE_DAY_SECOND; //default 86400
    public static long created = System.currentTimeMillis();
    public static int extendTime = 0;
    public static int version = 1;
    private static boolean isPrepared =true;
    private static int ERROR_CODE = -1;


    @Autowired
    public void BeansOnload(TimerDao timerDao,LetterDao letterDao,UserLetterDao userLetterDao,UserDao userDao,ResponseDao responseDao,UserInfoDao userInfoDao){
        TimerInstance.timerDao = timerDao;
        TimerInstance.letterDao =letterDao;
        TimerInstance.userLetterDao =userLetterDao;
        TimerInstance.userDao =userDao;
        TimerInstance.responseDao = responseDao;
        TimerInstance.userInfoDao = userInfoDao;
    }

    //单例模式组件
    private static TimerInstance timerInstance;
    private TimerInstance(){
    }
    public static TimerInstance getInstance(){
        if(timerInstance==null){
            return new TimerInstance();
        }else {
            return timerInstance;
        }
    }

    /**
     * @return 增加的时间
     */
    public static synchronized int extendLifeTo12H(){
        //Tip 在倒计时时长小于12h时，回帖则可以重置时长为12h；如果倒计时时长大于12，回帖不会对倒计时产生任何影响
        return extendLife(HALF_DAY_SECOND);
    }
    public static synchronized int extendLifeTo24H(){
        //Tip 发新贴重置为24H
        return extendLife(ONE_DAY_SECOND);
    }
    private static synchronized int extendLife(int TargetTime){
        int leftTime = getLeftTimeOfSecond();
        int timeToExtend;
        if(leftTime >= TargetTime){
            //do nothing
            return 0;
        }else {
            //
            timeToExtend = TargetTime-leftTime;
            TimerInstance.extendTime += timeToExtend;
            return timeToExtend;
        }
    }

    public static void setVersion(int version){
        TimerInstance.version=version;
    }
    public static int getLeftTimeOfSecond(){
        if(isPrepared){
            return TIMER_INITIAL+extendTime-(int) ((System.currentTimeMillis()-created)/1000);
        }else {
            myLogger.Warn("GetTime When resetting");
            return ERROR_CODE;
        }

    }
    public static int getLivingTimeOfSecond(){
        if(isPrepared){
            return (int) ((System.currentTimeMillis()-created)/1000);
        }else {
            myLogger.Warn("GetTime When resetting");
            return ERROR_CODE;
        }
    }
    public static boolean isDead(){
        return (getLeftTimeOfSecond()<=0)? true:false;
    }

    /*重置计时器*/
    public boolean reset(){

        //清空数据 保存版本
        Timer timer = new Timer();
        timer.setVersion(version);
        timer.setLivingTime(getLivingTimeOfSecond());
        timerDao.save(timer);

        //Tip 关闭读取 顺序扭曲= =
        isPrepared = false;

        extendTime = 0;
        version = version+1;

        //更新UserInfo
        boolean resE=true;

        List<User> userList = userDao.selectAll();
        for(User user:userList){
            int uid = user.getUid();
            //1. 记录LetterCount tip 有个可能的bug是Version不连续
            resE = resE && userInfoDao.updateLetterCountByUid(uid,version-1,letterDao.getLetterCountByUid(uid));
            //2. 创建UserInfo 此处的Version为新版本
            resE = resE && userInfoDao.create(new UserInfo(uid,version));
        }

        //更新四大表
        boolean resA = userDao.resetAll();
        boolean resB = letterDao.deleteAll();
        boolean resC = responseDao.deleteAll();
        boolean resD = userLetterDao.deleteAll();

        //tip 为了效率考虑的移位
        created = System.currentTimeMillis();

        //允许读取
        isPrepared = true;

        //重新监听
        init();

        return resA&&resB&&resC&&resD&&resE;
    }
    /*设置监听*/
    public static void init(){
        try{
            version = timerDao.getCurrentVersion()+1;
        }catch (BindingException e){
            // 数据库为空
            version = 1;
        }
        Thread thread = new Thread(new MonitorTask());
        thread.setName("TimerM v"+version);
        thread.start();
    }
}

