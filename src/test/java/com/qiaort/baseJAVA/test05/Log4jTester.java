package com.qiaort.baseJAVA.test05;


import org.apache.log4j.Logger;

public class Log4jTester {
    public static Logger logger= Logger.getLogger(Log4jTester.class);
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        //记录debug级别的日志
        logger.debug("这是我的debug级别的日志");
        //记录info级别的日志
        logger.info("这是我的info级别的日志");
        //记录warn级别的日志
        logger.warn("这是我的warn级别的日志");
        //记录error级别的日志
        logger.error("这是我的error级别的日志");
    }
}
