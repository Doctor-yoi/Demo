package com.research.demo.logger;

import com.research.demo.constant.enums.LogLevel;

public class LoggingEvent {
    public long timestamp;
    private LogLevel logLevel;
    private Object message;
    private String threadName;
    private long threadId;
    private String loggerName;

    public LoggingEvent(LogLevel logLevel, Object message, String loggerName) {
        this.logLevel = logLevel;
        this.message = message;
        this.loggerName = loggerName;
        this.timestamp = System.currentTimeMillis();
        Thread ct = Thread.currentThread();
        this.threadId = ct.getId();
        this.threadName = ct.getName();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public LogLevel getLevel() {
        return logLevel;
    }

    public void setLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    @Override
    public String toString() {
        return "LoggingEvent{" +
                "timestamp=" + timestamp +
                ", logLevel=" + logLevel +
                ", message=" + message +
                ", threadName='" + threadName + '\'' +
                ", threadId=" + threadId +
                ", loggerName='" + loggerName + '\'' +
                '}';
    }
}
