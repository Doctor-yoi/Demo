package com.research.demo.logger.layout.pattern;

import com.research.demo.logger.LoggingEvent;

public class ThreadConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent e) {
        return e.getThreadName();
    }
}
