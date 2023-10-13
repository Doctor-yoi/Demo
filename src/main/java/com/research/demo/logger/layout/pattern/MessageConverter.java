package com.research.demo.logger.layout.pattern;

import com.research.demo.logger.LoggingEvent;

public class MessageConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent e) {
        return String.valueOf(e.getMessage());
    }
}
