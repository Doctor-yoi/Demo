package com.research.demo.exceptions;

public class DataBaseException extends Exception{
    public DataBaseException(Exception e) {
        super(e);
    }
    
    public DataBaseException(String message) {
        super(message);
    }
}
