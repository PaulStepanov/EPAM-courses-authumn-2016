package DAO;

import domain.City;
import exeptions.PersistExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Павел on 28-Nov-16.
 */
public class CityMySQLDAO implements CityDAO {
    private Connection connection;
    private final String readStatement = "SELECT name FROM cities WHERE name=?";

    public CityMySQLDAO(Connection connection) {
        this.connection = connection;
    }

    public City read(String key) throws PersistExeption {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            City city = null;
            if (resultSet.next()) {
                city = new City();
                city.setId(resultSet.getString("name"));
            }
            return city;
        } catch (SQLException e) {
            throw new PersistExeption();
        }
    }

    public void delete(String key) {
        throw new UnsupportedOperationException();
    }

    public String create(City city) {
        throw new UnsupportedOperationException();
    }

    public void update(City city) {
        throw new UnsupportedOperationException();
    }
}
