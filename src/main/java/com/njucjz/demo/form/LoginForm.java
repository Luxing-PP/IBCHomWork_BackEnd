package com.njucjz.demo.form;

import lombok.Data;

@Data
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


