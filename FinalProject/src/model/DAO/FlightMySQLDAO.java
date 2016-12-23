package model.DAO;

import model.domain.Flight;
import model.parsers.TimeParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightMySQLDAO implements FlightDAO {
    private Connection connection;
    private final String findAllStatement="SELECT `ID`,`name`,`max_lagage_count`,`flight_time`,`departure_ID`,`arrival_ID` FROM flight;";
    private final String readStatement = "SELECT `ID`,`name`,arrival_ID,departure_ID,flight_time,max_lagage_count FROM flight WHERE ID=?";
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
                flight=createFlightEntitty(resultSet);
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

    @Override
    public List<Flight> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllStatement);
            Flight flight;
            ArrayList<Flight> flights= new ArrayList<Flight>();
            while (resultSet.next()) {
                flight = createFlightEntitty(resultSet);
                flights.add(flight);
            }
            if (flights.size() != 0) {
                return flights;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Flight createFlightEntitty(ResultSet resultSet) {
        Flight flight = null;
        try {
            flight = new Flight();
            flight.setId(resultSet.getInt("ID"));
            flight.setName(resultSet.getString("name"));
            flight.setArrivalCity(cityDAO.read(resultSet.getInt("arrival_ID")));
            flight.setDepartureCity(cityDAO.read(resultSet.getInt("departure_ID")));
            flight.setFlightTime(TimeParser.parseTimeToDuration(
                    resultSet.getString("flight_time")
            ));
            flight.setMaxLagage(resultSet.getInt("max_lagage_count"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection connection) {
        this.cityDAO.setConnection(connection);
        this.connection = connection;
    }
}
