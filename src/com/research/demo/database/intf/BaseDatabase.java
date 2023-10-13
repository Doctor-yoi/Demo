package com.research.demo.database.intf;

public interface BaseDatabase {
    public abstract boolean insert();
    
    public abstract boolean delete();
    
    public abstract void select();
    
    public abstract void update();
}
