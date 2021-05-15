package com.njucjz.demo.data;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Letter {
    private Integer lid;
    private Integer uid;
    private String content;
//    todo check stamp
    private Timestamp created;
}
