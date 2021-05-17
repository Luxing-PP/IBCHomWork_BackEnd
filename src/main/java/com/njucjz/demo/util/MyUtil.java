package com.njucjz.demo.util;

public class MyUtil {
    /**
     * 计算是否需要手动返回相关信件
     * @param missTimes
     * @return
     */
    public static boolean isNeedRelativeLetter(int missTimes){
        int base = (int)(3*Math.random())+1 ;

        //从每三封开始可能有，每六封必有一封是
        if ((base+missTimes)>=6){
            return true;
        }else {
            return false;
        }
    }
}
