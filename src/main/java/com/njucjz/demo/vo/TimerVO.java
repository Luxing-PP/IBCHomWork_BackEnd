package com.njucjz.demo.vo;

public class TimerVO {
    private Integer version;
    //请求旧版本是看不到leftTime的
    private Integer leftTime;
    private Integer livingTime;

    public Integer getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(Integer leftTime) {
        this.leftTime = leftTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getLivingTime() {
        return livingTime;
    }

    public void setLivingTime(Integer livingTime) {
        this.livingTime = livingTime;
    }
}
