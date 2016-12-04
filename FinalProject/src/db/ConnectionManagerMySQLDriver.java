package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Getting connection using mysql jdbc driver  */
public class ConnectionManagerMySQLDriver implements ConnectionManager {
    private Connection connection;

    public ConnectionManagerMySQLDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.connection = DriverManager.getConnection(SETTINGS.getProp("url")
                    + "?user=" + SETTINGS.getProp("user") + "&password=" + SETTINGS.getProp("password"));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
