package model.db;

import java.sql.Connection;

//Static pool manager for getting connections
public class ConnectionPoolManagerSingletone{
    private static ConnectionPoolManagerSingletone ourInstance = new ConnectionPoolManagerSingletone();
    private ConnectionPoolManager poolManager;

    public static ConnectionPoolManager getConnectionPoolManager() {
        return ourInstance.poolManager ;
    }
    public static Connection getConnection(){
        return ourInstance.poolManager.getConnection();
    }


    private ConnectionPoolManagerSingletone() {
        this.poolManager=new ConnectionPoolManager();
    }


}
