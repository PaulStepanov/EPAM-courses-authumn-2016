package model.DAO;

import model.domain.Client;
import model.exeptions.PersistExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMySQLDAO implements ClientDAO {
    private final String readStatement = "SELECT `name`,surname,patronymic,phone FROM clients WHERE users_ID=?;";
    private Connection connection;
    private UserDAO userDAO;

    public ClientMySQLDAO(UserDAO userDAO, Connection connection) {
        this.userDAO = userDAO;
        this.connection = connection;
    }
    public ClientMySQLDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection connection) {
        userDAO.setConnection(connection);
        this.connection = connection;
    }

    public Client read(Integer key) throws PersistExeption {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            Client client = null;
            if (resultSet.next()) {
                client = new Client();
                client.setId(key);
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setPatronymic(resultSet.getString("patronymic"));
                client.setPhone(resultSet.getString("phone"));
                client.setUser(userDAO.read(key));
            }
            return client;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Integer key) throws PersistExeption {

    }

    public Integer create(Client client) throws PersistExeption {
        return null;
    }

    public void update(Client client) throws PersistExeption {

    }

}
