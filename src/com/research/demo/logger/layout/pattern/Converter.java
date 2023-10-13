package com.research.demo.logger.layout.pattern;

import com.research.demo.logger.LoggingEvent;

public interface Converter {

    String convert(LoggingEvent e);

}
