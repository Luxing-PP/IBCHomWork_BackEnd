package com.njucjz.demo.util;

public class TimerInstance {
    // ms
    public static long created = System.currentTimeMillis();
    public static long extendTime = 0;
    public static int version = 0;

    public static synchronized void addTime(long extendTime){
        TimerInstance.extendTime+=extendTime;
    }
    public static void setVersion(int version){
        TimerInstance.version=version;
    }
    public static long getLeftTimeOfMs(){
        return (System.currentTimeMillis()-created+extendTime);
    }
}
