package model.DAO;

import model.domain.Ticket;
import model.exeptions.PersistExeption;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketMySQLDAO implements TicketDAO {
    private final String readStatement = "SELECT ID,flight_cost,clients_users_ID,lagage_capacity,VIP,current_flight_ID FROM tickets WHERE ID=?;";
    private final String findAllStatement = "SELECT ID,flight_cost,clients_users_ID,lagage_capacity,VIP,current_flight_ID FROM tickets";
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
                ticket = createTicketEntitty(resultSet);
            }
            return ticket;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Ticket> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllStatement);
            Ticket ticket;
            ArrayList<Ticket> tickets = new ArrayList<Ticket>();
            while (resultSet.next()) {
                ticket = createTicketEntitty(resultSet);
                tickets.add(ticket);
            }
            if (tickets.size() != 0) {
                return tickets;
            }
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


    private Ticket createTicketEntitty(ResultSet resultSet) {
        Ticket ticket = null;
        try {
            ticket = new Ticket();
            ticket.setId(resultSet.getInt("ID"));
            ticket.setFlightCost(resultSet.getInt("flight_cost"));
            ticket.setClient(clientDAO.read(resultSet.getInt("clients_users_ID")));
            ticket.setLagageCapacity(resultSet.getInt("lagage_capacity"));
            ticket.setVip(resultSet.getBoolean("VIP"));
            ticket.setCurrentFlight(currentFlightDao.read(resultSet.getInt("current_flight_ID")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }
}
