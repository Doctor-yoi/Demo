package com.research.demo.logger.layout.pattern;

import com.research.demo.logger.LoggingEvent;

public class LevelConverter implements Converter {

    @Override
    public String convert(LoggingEvent e) {
        return e.getLevel().toString();
    }

}