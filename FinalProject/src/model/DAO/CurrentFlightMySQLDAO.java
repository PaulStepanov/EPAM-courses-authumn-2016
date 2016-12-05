package model.DAO;

import model.domain.CurrentFlight;
import model.exeptions.PersistExeption;
import model.parsers.DateTimeParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrentFlightMySQLDAO implements CurrentFlightDao {
    private Connection connection;
    private final String readStatement = "SELECT ticket_cost,`date`,lagage_cost,flight_ID FROM current_flight WHERE ID=?";
    private FlightDAO flightDAO;

    public CurrentFlightMySQLDAO(FlightDAO flightDAO, Connection connection) {
        this.flightDAO = flightDAO;
        this.connection = connection;
    }

    public CurrentFlight read(Integer key) throws PersistExeption {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            CurrentFlight currentFlight = null;
            if (resultSet.next()) {
                currentFlight = new CurrentFlight();
                currentFlight.setId(key);
                currentFlight.setTicket_cost(resultSet.getInt("ticket_cost"));
                currentFlight.setDateTime(DateTimeParser.parse(resultSet.getString("date").trim()));
                currentFlight.setLagageCost(resultSet.getInt("lagage_cost"));
                currentFlight.setFlight(flightDAO.read(resultSet.getInt("flight_ID")));
            }
            return currentFlight;
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
}
