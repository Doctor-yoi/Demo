package com.research.demo.logger.layout;

import com.research.demo.logger.LifeCycle;
import com.research.demo.logger.LoggingEvent;

public interface Layout extends LifeCycle {
    String doLayout(LoggingEvent e);
}
