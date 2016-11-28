package DAO;

import domain.FlightEntity;
import parsers.TimeParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Павел on 28-Nov-16.
 */
public class FlightMySQLDAO implements FlightDAO {
    private Connection connection;
    private final String readStatement = "SELECT name,arrival_ID,departure_ID,flight_time,max_lagage_count FROM flight WHERE ID=?";
    private CityDAO cityDAO;

    public FlightMySQLDAO(CityDAO cityDAO, Connection connection) {
        this.cityDAO = cityDAO;
        this.connection = connection;
    }

    public FlightEntity read(Integer key) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            FlightEntity flightEntity = null;
            if (resultSet.next()) {
                flightEntity = new FlightEntity();
                flightEntity.setName(resultSet.getString("name"));
                flightEntity.setArrivalCity(cityDAO.read(resultSet.getInt("arrival_ID")));
                flightEntity.setDepartureCity(cityDAO.read(resultSet.getInt("departure_ID")));
                flightEntity.setFlightTime(TimeParser.parseTimeToDuration(
                                                                resultSet.getString("flight_time")
                ));
                flightEntity.setMaxLagage(resultSet.getInt("max_lagage_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Integer key) {
    }

    public Integer create(FlightEntity flightEntity) {
        return null;
    }

    public void update(FlightEntity flightEntity) {

    }
}
