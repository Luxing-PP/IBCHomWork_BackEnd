package com.njucjz.demo.util;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        myLogger.Info("Using InitializeRunner init");
        TimerInstance.init();
    }
}
