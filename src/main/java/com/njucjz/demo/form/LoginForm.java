package com.njucjz.demo.form;

import lombok.Data;

@Data
public class LoginForm {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


