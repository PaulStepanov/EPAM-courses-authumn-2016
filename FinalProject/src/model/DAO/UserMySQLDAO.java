package model.DAO;

import model.domain.User;
import model.domain.UserBuilder;
import model.exeptions.PersistExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class UserMySQLDAO implements UserDAO {
    private Connection connection;
    private final String readStatement = "SELECT login,password,email,priviliges_lvl FROM `users` WHERE ID=?";
    private final String findByLoginStatement = "SELECT ID from users WHERE `login`=? AND `password`=? ";

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
                user = new UserBuilder()
                        .setLogin(resultSet.getString("login"))
                        .setPassword(resultSet.getString("password"))
                        .setEmail(resultSet.getString("email"))
                        .setPriviligesLvl(resultSet.getInt("priviliges_lvl"))
                        .createUser();
                user.setId(key);
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

    @Override
    public User readByLoginAndPassword(String login, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findByLoginStatement);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return this.read(resultSet.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
