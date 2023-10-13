package com.research.demo.logger.appender;

import com.research.demo.logger.LifeCycle;
import com.research.demo.logger.LoggingEvent;

public interface Appender extends LifeCycle {

    String getName();

    void setName(String name);

    void append(LoggingEvent e);
}
