package model.db;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}
