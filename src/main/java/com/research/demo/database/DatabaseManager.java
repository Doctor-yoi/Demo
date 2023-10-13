package com.research.demo.database;


import com.research.demo.constant.enums.DbType;
import com.research.demo.constant.enums.UserPermission;
import com.research.demo.domain.User;
import com.research.demo.exceptions.DataBaseException;
import com.research.demo.logger.Logger;
import com.research.demo.logger.LoggerFactory;

public class DatabaseManager {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseManager.class);
    private LocalDB localDB;
    //在此处添加其他数据库
    public DatabaseManager(DbType type){
        logger.debug("Database manager is initializing...");
        this.type = type;
        logger.debug("Database manager has initialized.database type:"+type.name());
    }
    public void connect() throws DataBaseException {
        logger.info("Connecting to database");
        switch (type){
            case LOCAL_DB :
                localDB = new LocalDB();
                try {
                    localDB.connect();
                    logger.info("Connected to LocalDB");
                }catch (Exception e){
                    logger.error("Connection failed!");
                    throw new DataBaseException(e);
                }
                break;
            default:
                break;
        }
    }
    public void insert(User user) throws DataBaseException{
        try{
            switch (type){
                case LOCAL_DB :
                    localDB.insert(user);
                    logger.info("Successfully insert data into LocalDB. Insert Data:"+user.toString());
                    break;
                default:
                    break;
            }
        }catch (Exception e) {
            logger.error("insert failed");
            throw new DataBaseException(e);
        }
    }
    public void update(User user) throws DataBaseException{
        try {
            switch (type){
                case LOCAL_DB :
                    localDB.update(user);
                    logger.info("Successfully update data in LocalDB. Update Data:"+user.toString());
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            throw new DataBaseException(e);
        }
    }
    public void delete(User user) throws DataBaseException{
        try {
            switch (type){
                case LOCAL_DB :
                    localDB.delete(user);
                    logger.info("Successfully delete data in LocalDB.");
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            throw new DataBaseException(e);
        }
    }
    public User select(User user) throws DataBaseException{
        User result = new User("default","default",123, UserPermission.NO_PERMISSION);
        try{
            switch (type){
                case LOCAL_DB :
                    result = localDB.select(user);localDB.insert(user);
                    logger.info("Find data in LocalDB. Data:"+result.toString());
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            logger.error("Can't find proper data.");
            throw new DataBaseException(e);
        }
        return result;
    }
    
    public String getTypeName() {
        return type.name();
    }
    
    private DbType type;
    
}
