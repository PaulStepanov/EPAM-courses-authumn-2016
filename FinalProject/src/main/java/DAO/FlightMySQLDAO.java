package DAO;

import domain.FlightEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Павел on 28-Nov-16.
 */
public class FlightMySQLDAO implements DAO<FlightEntity, String> {
    private Connection connection;
    private final String readStatement = "SELECT name,arrival,departure,flight_time,max_lagage_count FROM flight WHERE name=?";
    private CityDAO cityDAO;

    public FlightMySQLDAO(CityDAO cityDAO,Connection connection) {
        this.cityDAO=cityDAO;
        this.connection = connection;
    }

    public FlightEntity read(String key) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            FlightEntity flightEntity = null;
            if (resultSet.next()) {
                flightEntity = new FlightEntity();
                flightEntity.setName(resultSet.getString("name"));
                flightEntity.setArrivalCity(cityDAO.read(resultSet.getString("arrival")));
                flightEntity.setDepartureCity(cityDAO.read(resultSet.getString("departure")));
                flightEntity.setFlightTime();
                flightEntity.setMaxLagage(resultSet.getInt("max_lagage_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String key) {

    }

    public String create(FlightEntity flightEntity) {
        return null;
    }

    public void update(FlightEntity flightEntity) {

    }
}
