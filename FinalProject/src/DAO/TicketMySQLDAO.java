package DAO;

import domain.Ticket;
import exeptions.PersistExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMySQLDAO implements TicketDAO {
    private final String readStatement = "SELECT flight_cost,clients_users_ID,lagage_capacity,VIP,current_flight_ID FROM tickets WHERE ID=?;";
    private ClientDAO clientDAO;
    private CurrentFlightDao currentFlightDao;
    private Connection connection;

    public TicketMySQLDAO(ClientDAO clientDAO, CurrentFlightDao currentFlightDao, Connection connection) {
        this.clientDAO = clientDAO;
        this.currentFlightDao = currentFlightDao;
        this.connection = connection;
    }


    public Ticket read(Integer key) throws PersistExeption {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(readStatement);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            Ticket ticket = null;
            if (resultSet.next()) {
                ticket = new Ticket();
                ticket.setId(key);
                ticket.setFlightCost(resultSet.getInt("flight_cost"));
                ticket.setClient(clientDAO.read(resultSet.getInt("clients_users_ID")));
                ticket.setLagageCapacity(resultSet.getInt("lagage_capacity"));
                ticket.setVip(resultSet.getBoolean("VIP"));
                ticket.setCurrentFlight(currentFlightDao.read(resultSet.getInt("current_flight_ID")));
            }
            return ticket;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Integer key) throws PersistExeption {

    }

    public Integer create(Ticket ticket) throws PersistExeption {
        return null;
    }

    public void update(Ticket ticket) throws PersistExeption {

    }
}
