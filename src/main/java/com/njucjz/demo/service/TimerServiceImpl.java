package com.njucjz.demo.service;

import com.njucjz.demo.dao.TimerDao;
import com.njucjz.demo.data.Timer;
import com.njucjz.demo.util.TimerInstance;
import com.njucjz.demo.vo.TimerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimerServiceImpl implements TimerService {
    @Autowired
    TimerDao timerDao;

    @Override
    public TimerVO getTimer() {
        TimerVO timerVO = new TimerVO();
        //完全手算doge
        timerVO.setVersion(TimerInstance.version);
        timerVO.setLivingTime(TimerInstance.getLivingTimeOfSecond());
        timerVO.setLeftTime(TimerInstance.getLeftTimeOfSecond());

        return timerVO;
    }

    @Override
    public TimerVO getTimerByVersion(Integer version) {
        if(version==TimerInstance.version){
            //当前周期不支持
            return null;
        }else {
            Timer timer = timerDao.getTimerByVersion(version);
            if(timer==null){
                return null;
            }

            TimerVO timerVO = new TimerVO();
            BeanUtils.copyProperties(timer,timerVO);
            return timerVO;
        }
    }

    @Override
    public boolean save() {
        Timer timer = new Timer();
        timer.setVersion(TimerInstance.version);
        timer.setLivingTime(TimerInstance.getLivingTimeOfSecond());

        return timerDao.save(timer);
    }
}
