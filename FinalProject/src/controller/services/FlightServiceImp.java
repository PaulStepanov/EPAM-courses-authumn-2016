package controller.services;

import model.DAO.FabrikMySQLDAO;
import model.DAO.FlightDAO;
import model.db.ConnectionManager;
import model.domain.Flight;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FlightServiceImp implements FlightService {
    FlightDAO flightDAO;
    ConnectionManager connectionManager;

    public FlightServiceImp(ConnectionManager connectionManager) {
        flightDAO= (FlightDAO) new FabrikMySQLDAO().createDAO(FlightDAO.class);
        this.connectionManager = connectionManager;
        }

    @Override
    public List<Flight> findAll() {
        Connection connection = connectionManager.getConnection();
        flightDAO.setConnection(connection);
        List<Flight> result=flightDAO.findAll();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
