package com.research.demo;

import com.research.demo.logger.LoggerFactory;
import com.research.demo.logger.Logger;
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("test");
    }
}