package com.research.demo.logger;

public class ConfigException extends RuntimeException {
    public ConfigException(Exception e) {
        super(e);
    }

    public ConfigException(String message) {
        super(message);
    }
}
