package controller.services;

import model.DAO.UserDAO;
import model.DAO.UserMySQLDAO;
import model.db.ConnectionManager;
import model.domain.User;

import java.sql.Connection;

public class UsersServiceIml implements UsersService {
    private UserDAO userDAO;
    private boolean validUser=false;
    private Connection connection;

    public UsersServiceIml( ConnectionManager connectionManager) {
        this.connection = connectionManager.getConnection();
        this.userDAO = new UserMySQLDAO(this.connection);
    }


    public User getByLoginAndPassword(String login, String password) {
        return userDAO.readByLoginAndPassword(login,password);
    }
}
