package controller.services;

import model.DAO.FabrikMySQLDAO;
import model.DAO.UserDAO;
import model.db.ConnectionManager;
import model.domain.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersServiceIml implements UsersService {
    private UserDAO userDAO;
    private boolean validUser=false;
    private ConnectionManager connectionManager;

    public UsersServiceIml( ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        this.userDAO = (UserDAO) FabrikMySQLDAO.getDAO(UserDAO.class);
    }


    public User getByLoginAndPassword(String login, String password) {
        Connection connection = connectionManager.getConnection();
        userDAO.setConnection(connection);
        User result=userDAO.readByLoginAndPassword(login,password);
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
