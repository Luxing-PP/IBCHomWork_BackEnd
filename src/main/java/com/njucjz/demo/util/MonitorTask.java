package com.njucjz.demo.util;

import com.njucjz.demo.dao.TimerDao;
import com.njucjz.demo.data.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 对TimerInstance进行轮询
 */
public class MonitorTask implements Runnable {
    final long timeInterval = 30000;// 两分钟运行一次 120000
    private TimerInstance timerInstance= TimerInstance.getInstance();

    @Override
    public void run() {
        boolean isFinished = false;

        while (!isFinished){
            if(TimerInstance.isDead()){
                boolean isProper =  timerInstance.reset();
                if(!isProper){
                    myLogger.Warn("TimerResetError!");
                }else {
                    myLogger.Info("TimerReset Now Version:"+ TimerInstance.version);
                }
                isFinished = true;
            }else {
                myLogger.Info("TimerLeftTime: "+TimerInstance.getLeftTimeOfSecond());
            }

            try {
                Thread.sleep(timeInterval);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
