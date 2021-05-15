package com.njucjz.demo.service;

import com.njucjz.demo.data.Timer;
import com.njucjz.demo.vo.TimerVO;


public interface TimerService {
    /*返回本周期剩余时长、已存在时长、已毁灭过几次（借助version）*/
    TimerVO getTimer();

    /*获取过去某次剩余时间*/
    TimerVO getTimerByVersion(Integer version);
    //tip 虽然我觉得这个按逻辑上不在service层，但我不知道怎么越过service访问DAO

    /*保存重启前信息*/
    boolean save();
}
