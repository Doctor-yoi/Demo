package com.research.demo.logger.filter;

import com.research.demo.logger.LifeCycle;
import com.research.demo.logger.LoggingEvent;

public interface Filter extends LifeCycle {
    boolean doFilter(LoggingEvent event);
}
