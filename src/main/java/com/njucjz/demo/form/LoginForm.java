package com.njucjz.demo.form;

import lombok.Data;

@Data
//todo 迷 有GETSET 为啥就能读出来了
public class LoginForm {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


