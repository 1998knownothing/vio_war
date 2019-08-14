package com.ye.vio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: vio
 * @description:
 * @author: Mr.liu
 * @create: 2019-08-04 22:46
 **/
public class LogTest {

    private static final  Logger logger= LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.trace("logback的--trace日志--输出了");
        logger.debug("logback的--debug日志--输出了");
        logger.info("logback的--info日志--输出了");
        logger.warn("logback的--warn日志--输出了");
        logger.error("logback的--error日志--输出了");
    }

}
