package com.research.demo.logger.filter;

import com.research.demo.constant.enums.LogLevel;
import com.research.demo.logger.LoggingEvent;

public class LevelFilter implements Filter{

    private String level;

    private LogLevel l;

    @Override
    public boolean doFilter(LoggingEvent event) {
        return event.getLevel().isGreaterOrEqual(l);
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public void start() {
        this.l = LogLevel.parse(level);
    }

    @Override
    public void stop() {

    }
}
