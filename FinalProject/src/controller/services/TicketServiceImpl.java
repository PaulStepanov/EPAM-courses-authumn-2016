package controller.services;

import controller.services.connection.ConnectionServiceControl;
import model.DAO.FabricMySADA;
import model.DAO.TicketDAO;
import model.db.ConnectionManager;
import model.domain.Client;
import model.domain.CurrentFlight;
import model.domain.Ticket;
import model.exeptions.PersistExeption;

import java.util.List;

class TicketServiceImpl implements TicketService {
    TicketDAO ticketDAO;
    ConnectionManager connectionManager;
    ConnectionServiceControl connectionService;

    TicketServiceImpl(ConnectionManager connectionManag) {
        this.connectionManager = connectionManag;
        this.ticketDAO = (TicketDAO) FabricMySADA.getDAO(TicketDAO.class);
        this.connectionService = new ConnectionServiceControl(ticketDAO);
    }

    public List<Ticket> findAll() {
        connectionService.setConnection(connectionManager.getConnection());
        List<Ticket> result = ticketDAO.findAll();
        connectionService.releaseConection();
        return result;
    }

    @Override
    public List<Ticket> findByUser(Integer userID) {
        connectionService.setConnection(connectionManager.getConnection());
        List<Ticket> result = ticketDAO.findByUser(userID);
        connectionService.releaseConection();
        return result;
    }

    @Override
    public boolean registerTicket(Integer currentFlightId, Integer luggage, boolean VIP, Integer clientID) {
        CurrentFlightService currentFlightService = (CurrentFlightService) ServiceManager.getService(CurrentFlightService.class);
        CurrentFlight currentFlight = currentFlightService.find(currentFlightId);
        if (luggage > currentFlight.getFlight().getMaxLagage()) {
            return false;
        }
        connectionService.setConnection(connectionManager.getConnection());
        Ticket ticket = new Ticket();
        CurrentFlight flight = new CurrentFlight();
        flight.setId(currentFlightId);
        ticket.setCurrentFlight(flight);
        ticket.setVip(VIP);

        ticket.setLagageCapacity(luggage);
        Client client = new Client();
        client.setId(clientID);
        ticket.setClient(client);

        Integer cost = 0;
        cost += currentFlight.getTicketCost();
        cost += currentFlight.getLagageCost() * luggage;
        ticket.setFlightCost(cost);
        try {
            ticketDAO.create(ticket);
            return true;
        } catch (PersistExeption throwables) {
            throwables.printStackTrace();
        }
        connectionService.releaseConection();
        return false;
    }
}
