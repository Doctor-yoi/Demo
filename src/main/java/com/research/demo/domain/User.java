package com.research.demo.domain;

import com.research.demo.constant.enums.UserPermission;

public class User {
    public User(String username, String password, long uid, UserPermission userPermission) {
        this.username = username;
        this.password = password;
        this.uid = uid;
        this.userPermission = userPermission;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public long getUid() {
        return uid;
    }
    
    public void setUid(long uid) {
        this.uid = uid;
    }
    
    public UserPermission getUserPermission() {
        return userPermission;
    }
    
    public void setUserPermission(UserPermission userPermission) {
        this.userPermission = userPermission;
    }
    
    public int getIndex() {
        return Index;
    }
    
    public void setIndex(int index) {
        Index = index;
    }
    
    private String username;
    private String password;
    private long uid;
    private UserPermission userPermission;
    private int Index;
    

    
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uid=" + uid +
                ", userPermission=" + userPermission +
                '}';
    }
    
}
