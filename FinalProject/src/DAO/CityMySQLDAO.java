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
    private final String readStatement = "SELECT name FROM cities WHERE ID=?";
    private Connection connection;

    public CityMySQLDAO(Connection connection) {
        this.connection = connection;
    }

    public City read(Integer key) throws PersistExeption {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            City city = null;
            if (resultSet.next()) {
                city = new City();
                city.setId(resultSet.getInt("ID"));
                city.setName(resultSet.getString("name"));
            }
            return city;
        } catch (SQLException e) {
            throw new PersistExeption();
        }
    }

    public void delete(Integer key) {
        throw new UnsupportedOperationException();
    }

    public Integer create(City city) {
        throw new UnsupportedOperationException();
    }

    public void update(City city) {
        throw new UnsupportedOperationException();
    }
}