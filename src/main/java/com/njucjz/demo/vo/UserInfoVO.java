package com.njucjz.demo.vo;

import lombok.Data;

@Data
public class UserInfoVO {
    private Integer letterCount;
    private Integer saveTimes;
    private Integer loginDay;

    public Integer getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(Integer letterCount) {
        this.letterCount = letterCount;
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
}
