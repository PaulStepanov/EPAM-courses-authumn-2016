package db;

import java.sql.Connection;


public interface ConnectionManager {
    public Connection getConnection();
}
