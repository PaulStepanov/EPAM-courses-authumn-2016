package controller.services;

import model.DAO.*;
import model.db.ConnectionManager;
import model.domain.Ticket;

import java.sql.Connection;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    TicketDAO ticketDAO;
    ConnectionManager connectionManager;

    public TicketServiceImpl(ConnectionManager connectionManag) {
        this.connectionManager = connectionManag;
        Connection connection = connectionManager.getConnection();
        UserDAO userDAO = new UserMySQLDAO(connection);
        ClientDAO clientDAO = new ClientMySQLDAO(userDAO, connection);
        CityDAO cityDAO = new CityMySQLDAO(connection);
        FlightDAO flightDAO = new FlightMySQLDAO(cityDAO, connection);
        CurrentFlightDao currentFlight = new CurrentFlightMySQLDAO(flightDAO, connection);
        this.ticketDAO = new TicketMySQLDAO(clientDAO, currentFlight, connection);
    }

    public List<Ticket> findAll() {
        return ticketDAO.findAll();
    }
}
