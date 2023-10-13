package com.research.demo.logger;

import com.research.demo.constant.enums.LogLevel;
import com.research.demo.logger.appender.AppenderAttachableImpl;

public class DemoLogger implements Logger , LifeCycle{

    private String name;
    private LogLevel logLevel = LogLevel.TRACE;
    private int effectiveLevelInt;
    private DemoLogger parent;
    private AppenderAttachableImpl aai;

    private LoggerContext loggerContext;

    @Override
    public void trace(String msg) {
        filterAndLog(LogLevel.TRACE,msg);
    }

    @Override
    public void info(String msg) {
        filterAndLog(LogLevel.INFO,msg);
    }

    @Override
    public void debug(String msg) {
        filterAndLog(LogLevel.DEBUG,msg);
    }

    @Override
    public void warn(String msg) {
        filterAndLog(LogLevel.WARN,msg);
    }

    @Override
    public void error(String msg) {
        filterAndLog(LogLevel.ERROR,msg);
    }

    @Override
    public String getName() {
        return name;
    }

    private void filterAndLog(LogLevel logLevel, String msg){
        LoggingEvent e = new LoggingEvent(logLevel, msg,getName());
        for (DemoLogger l = this; l != null; l = l.parent){
            if(l.aai == null){
                continue;
            }
            if(logLevel.toInt()>effectiveLevelInt){
                l.aai.appendLoopOnAppenders(e);
            }
            //优先使用当前logger，如果当前没有则向上查找，找到就跳出
            //默认情况下，如果不配置完整类名的logger，这里都需要向上查找，直至root
            //比如name=x.y.z.AClass，则配置logger name="x.y.z"，则Aclass会使用x.y.z这个logger
            break;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(LogLevel logLevel) {
        this.effectiveLevelInt = logLevel.toInt();
        this.logLevel = logLevel;
    }

    public void setEffectiveLevelInt(int effectiveLevelInt) {
        this.effectiveLevelInt = effectiveLevelInt;
    }

    public void setParent(Logger parent) {
        this.parent = (DemoLogger) parent;
    }

    public void setAai(AppenderAttachableImpl aai) {
        this.aai = aai;
    }

    public void setLoggerContext(LoggerContext loggerContext) {
        this.loggerContext = loggerContext;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
