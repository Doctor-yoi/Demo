package com.research.demo.logger.layout;

import com.research.demo.logger.LoggingEvent;

/**
 * 纯文本布局，直接调用{@link com.research.demo.logger.LoggingEvent#toString()}
 */
public class PlainLayout implements Layout {

    @Override
    public String doLayout(LoggingEvent e) {
        return e.toString();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
