package db;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import db.SETTINGS;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/airline");
//            Context envCtx = (Context) (new InitialContext().lookup("java:comp/env/jdbc/airline"));
//            DataSource ds = (DataSource) envCtx.lookup("jdbc/airline");
            this.connection=ds.getConnection();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            this.connection = DriverManager.getConnection(SETTINGS.getProp("url")
//                    + "?user=" + SETTINGS.getProp("user") + "&password=" + SETTINGS.getProp("password"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public Connection getConnection() {
        return this.connection;
    }

}
