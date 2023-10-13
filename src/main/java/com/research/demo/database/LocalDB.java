package com.research.demo.database;

import com.research.demo.domain.User;
import com.research.demo.exceptions.DataBaseException;

import java.util.ArrayList;
import java.util.List;

public class LocalDB {
    private List<User> userList = new ArrayList<User>();
    public LocalDB(){
    
    };
    public LocalDB connect() throws DataBaseException{
        return this;
    }
    
    public void insert(User user) throws DataBaseException{
        try{
            userList.add(user);
            user.setIndex(userList.size());
        }catch (Exception e) {
            throw new DataBaseException(e);
        }
    }
    public void update(User user) throws DataBaseException{
        try {
            userList.remove(user.getIndex()-1);
            userList.add(user);
            user.setIndex(userList.size());
        }catch (Exception e){
            throw new DataBaseException(e);
        }
    }
    public void delete(User user) throws DataBaseException{
        try {
            userList.remove(user.getIndex()-1);
        }catch (Exception e){
            throw new DataBaseException(e);
        }
    }
    public User select(User user) throws DataBaseException{
        try{
            return userList.get(user.getIndex()-1);
        }catch (Exception e){
            throw new DataBaseException(e);
        }
    }
}
