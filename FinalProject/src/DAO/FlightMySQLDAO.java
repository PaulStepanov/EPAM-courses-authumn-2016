package DAO;

import domain.Flight;
import parsers.TimeParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightMySQLDAO implements FlightDAO {
    private Connection connection;
    private final String readStatement = "SELECT `name`,arrival_ID,departure_ID,flight_time,max_lagage_count FROM flight WHERE ID=?";
    private CityDAO cityDAO;

    public FlightMySQLDAO(CityDAO cityDAO, Connection connection) {
        this.cityDAO = cityDAO;
        this.connection = connection;
    }

    public Flight read(Integer key) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            Flight flight = null;
            if (resultSet.next()) {
                flight = new Flight();
                flight.setId(key);
                flight.setName(resultSet.getString("name"));
                flight.setArrivalCity(cityDAO.read(resultSet.getInt("arrival_ID")));
                flight.setDepartureCity(cityDAO.read(resultSet.getInt("departure_ID")));
                flight.setFlightTime(TimeParser.parseTimeToDuration(
                                                                resultSet.getString("flight_time")
                ));
                flight.setMaxLagage(resultSet.getInt("max_lagage_count"));
            }
            return flight;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Integer key) {
    }

    public Integer create(Flight flight) {
        return null;
    }

    public void update(Flight flight) {

    }
}
