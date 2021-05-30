package com.njucjz.demo;

import com.njucjz.demo.util.TimerInstance;
import com.njucjz.demo.util.myLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {
    public static void main(String[] args) {
        myLogger.init(DemoApplication.class);
        SpringApplication.run(DemoApplication.class, args);
    }
}
