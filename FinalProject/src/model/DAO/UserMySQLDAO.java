package model.DAO;

import model.domain.User;
import model.exeptions.PersistExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMySQLDAO implements UserDAO {
    private Connection connection;
    private final String readStatement = "SELECT login,password,email,priviliges_lvl FROM `users` WHERE ID=?";

    public UserMySQLDAO(Connection connection) {
        this.connection = connection;
    }

    public User read(Integer key) throws PersistExeption {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(key);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPriviligesLvl(resultSet.getInt("priviliges_lvl"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistExeption();
        }
        return null;
    }

    public void delete(Integer key) throws PersistExeption {

    }

    public Integer create(User user) throws PersistExeption {
        return null;
    }

    public void update(User user) throws PersistExeption {

    }
}
