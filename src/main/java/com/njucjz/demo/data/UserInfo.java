package com.njucjz.demo.data;

public class UserInfo {
    private Integer infoID;
    private Integer uid;
    private Integer version;
    private Integer saveTimes;
    private Integer loginDay;
    private Integer letterCount;

    public Integer getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(Integer letterCount) {
        this.letterCount = letterCount;
    }

    public Integer getInfoID() {
        return infoID;
    }

    public void setInfoID(Integer infoID) {
        this.infoID = infoID;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getSaveTimes() {
        return saveTimes;
    }

    public void setSaveTimes(Integer saveTimes) {
        this.saveTimes = saveTimes;
    }

    public Integer getLoginDay() {
        return loginDay;
    }

    public void setLoginDay(Integer loginDay) {
        this.loginDay = loginDay;
    }

    public UserInfo(){

    }

    public UserInfo(Integer uid, Integer version){
        this.uid =uid;
        this.version = version;
    }
}
