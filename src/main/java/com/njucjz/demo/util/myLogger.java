package com.njucjz.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自用的封装Logger
 * */
public class myLogger {
    private static Logger logger;
    private static boolean canLog = true;

    public static void init(Class<?> clazz){
        logger = LoggerFactory.getLogger(clazz);
    }

    public static void Info(String str){
        if(logger==null){
            init(myLogger.class);
        }

        if(canLog){
            logger.info(str);
        }
    }

    public static void Warn(String str){
        if(logger==null){
            init(myLogger.class);
        }

        if(canLog){
            logger.warn(str);
        }
    }
}
