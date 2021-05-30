package com.njucjz.demo.dao;

import com.njucjz.demo.data.Timer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimerDao {
    /*保存上个版本的情况*/
    boolean save(Timer timer);
    Timer getTimerByVersion(Integer version);

    /*返回最大的version作为上次的version*/
    int getCurrentVersion();
}
