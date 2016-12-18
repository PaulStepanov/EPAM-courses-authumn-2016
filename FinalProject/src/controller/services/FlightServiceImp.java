package controller.services;

import model.DAO.CityDAO;
import model.DAO.CityMySQLDAO;
import model.DAO.FlightDAO;
import model.DAO.FlightMySQLDAO;
import model.db.ConnectionManager;
import model.domain.Flight;

import java.sql.Connection;
import java.util.List;

public class FlightServiceImp implements FlightService {
    FlightDAO flightDAO;
    ConnectionManager connectionManager;

    public FlightServiceImp(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        Connection connection = connectionManager.getConnection();
        CityDAO cityDAO = new CityMySQLDAO(connection);
        this.flightDAO= new FlightMySQLDAO(cityDAO,connection);
    }

    @Override
    public List<Flight> findAll() {
        return flightDAO.findAll();
    }
}
