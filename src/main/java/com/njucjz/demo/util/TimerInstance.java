package com.njucjz.demo.util;

public class TimerInstance {
    // ms
    public static int TIMER_INITIAL = 86400;
    public static long created = System.currentTimeMillis();
    //TODO 添加时间相关的完全没弄呢
    public static int extendTime = 0;
    public static int version = 1;

    public static synchronized void addTime(int extendTime){
        TimerInstance.extendTime+=extendTime;
    }
    public static void setVersion(int version){
        TimerInstance.version=version;
    }
    public static int getLeftTimeOfSecond(){
        return TIMER_INITIAL+extendTime-(int) ((System.currentTimeMillis()-created)/1000);
    }
    public static int getLivingTimeOfSecond(){
        return (int) ((System.currentTimeMillis()-created)/1000);
    }
}

