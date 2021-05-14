package com.njucjz.demo.data;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }
}
