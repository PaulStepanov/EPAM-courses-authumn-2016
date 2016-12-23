package controller.services;

import model.DAO.*;
import model.db.ConnectionManager;
import model.domain.Ticket;
import model.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    TicketDAO ticketDAO;
    ConnectionManager connectionManager;

    public TicketServiceImpl(ConnectionManager connectionManag) {
        this.connectionManager = connectionManag;
        this.ticketDAO = (TicketDAO) FabrikMySQLDAO.getDAO(TicketDAO.class);
    }

    public List<Ticket> findAll() {
        Connection connection= connectionManager.getConnection();
        ticketDAO.setConnection(connection);
        List<Ticket> result=ticketDAO.findAll();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Ticket> findByUser(User user) {
        return null;
    }
}
