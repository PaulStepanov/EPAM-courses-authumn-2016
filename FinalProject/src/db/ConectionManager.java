package db;

import db.SETTINGS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Павел on 29-Nov-16.
 */
public class ConectionManager {
    private Connection connection;

    public ConectionManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(SETTINGS.getProp("url")
                    + "?user=" + SETTINGS.getProp("user") + "&password=" + SETTINGS.getProp("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

}
