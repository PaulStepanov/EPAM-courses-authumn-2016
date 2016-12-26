package model.DAO;

import model.domain.CurrentFlight;
import model.exeptions.PersistExeption;
import model.parsers.DateTimeParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrentFlightMySQLDAO implements CurrentFlightDao {
    private Connection connection;
    private final String readStatement = "SELECT ID,ticket_cost,`date`,lagage_cost,flight_ID FROM current_flight WHERE ID=?";
    private final String findAll = "SELECT ID,ticket_cost,`date`,lagage_cost,flight_ID FROM current_flight";
    private FlightDAO flightDAO;

    public CurrentFlightMySQLDAO(FlightDAO flightDAO, Connection connection) {
        this.flightDAO = flightDAO;
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection connection) {
        flightDAO.setConnection(connection);
        this.connection = connection;
    }

    public CurrentFlight read(Integer key) throws PersistExeption {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            return createCurrentFlightEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Integer key) throws PersistExeption {

    }

    public Integer create(CurrentFlight currentFlight) throws PersistExeption {
        return null;
    }

    public void update(CurrentFlight currentFlight) throws PersistExeption {

    }

    @Override
    public List<CurrentFlight> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAll);
            CurrentFlight currentFlight;
            ArrayList<CurrentFlight> currentFlights = new ArrayList<CurrentFlight>();
            while (resultSet.next()) {
                currentFlight = createCurrentFlightEntity(resultSet);
                currentFlights.add(currentFlight);
            }
            if (currentFlights.size() != 0) {
                return currentFlights;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CurrentFlight createCurrentFlightEntity(ResultSet resultSet) throws SQLException {
        CurrentFlight currentFlight = null;
        if (resultSet.next()) {
            currentFlight = new CurrentFlight();
            currentFlight.setId(resultSet.getInt("ID"));
            currentFlight.setTicket_cost(resultSet.getInt("ticket_cost"));
            currentFlight.setDateTime(DateTimeParser.parseStringTime(resultSet.getString("date").trim()));
            currentFlight.setLagageCost(resultSet.getInt("lagage_cost"));
            currentFlight.setFlight(flightDAO.read(resultSet.getInt("flight_ID")));
        }
        return currentFlight;
    }
}
