package com.njucjz.demo.vo;


public class UserVO {
    private Integer uid;
    private String openid;
    private boolean isNewDay;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public boolean isNewDay() {
        return isNewDay;
    }

    public void setNewDay(boolean newDay) {
        isNewDay = newDay;
    }
}
