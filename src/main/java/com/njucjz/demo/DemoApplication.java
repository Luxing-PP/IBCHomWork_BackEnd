package com.njucjz.demo;

import com.njucjz.demo.util.TimerInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {
    public static void main(String[] args) {
        //开始计时
        TimerInstance timerInstance = new TimerInstance();
        SpringApplication.run(DemoApplication.class, args);
    }

}
