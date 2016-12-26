package model.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Getting dataSource from Tomcat dataSource pull.
 * Connection provided to users must be closed by user, in this case it will be returned to pool.
 */
public class ConnectionPoolManager implements ConnectionManager {
    private DataSource dataSource;

    //Initializing dataSource pool  using airline context.
    public ConnectionPoolManager() {
        try {
            Context ctx = new InitialContext();
            this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/airline");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
