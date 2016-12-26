package controller.services.connection;

import model.DAO.DBDAO;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionServiceControl {
    private DBDAO dao;

    public ConnectionServiceControl(DBDAO dao) {
        this.dao = dao;
    }

    public void setConnection(Connection connection) {
        releaseConection();
        dao.setConnection(connection);
    }

    public void releaseConection() {
        try {
            if (dao.getConnection() != null) {
                dao.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
