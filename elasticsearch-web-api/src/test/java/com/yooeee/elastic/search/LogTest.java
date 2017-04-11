package com.yooeee.elastic.search;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/4/6.
 */
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test(){
        logger.info("this is info");
        logger.warn("this is info");
        logger.debug("this is info");
        logger.error("this is info");
    }
}
