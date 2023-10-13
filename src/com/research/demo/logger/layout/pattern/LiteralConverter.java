package com.research.demo.logger.layout.pattern;

import com.research.demo.logger.LoggingEvent;

public class LiteralConverter implements Converter {

    private String literal;

    @Override
    public String convert(LoggingEvent e) {
        return literal;
    }

    public LiteralConverter(String literal) {
        this.literal = literal;
    }
}
