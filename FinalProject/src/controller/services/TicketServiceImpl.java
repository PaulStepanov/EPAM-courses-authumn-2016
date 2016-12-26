package controller.services;

import controller.services.connection.ConnectionServiceControl;
import model.DAO.FabricMySADA;
import model.DAO.TicketDAO;
import model.db.ConnectionManager;
import model.domain.Client;
import model.domain.CurrentFlight;
import model.domain.Ticket;
import model.domain.builders.ClientBuilder;
import model.domain.builders.CurrentFlightBuilder;
import model.domain.builders.TicketBuilder;
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
        TicketBuilder ticketBuilder = new TicketBuilder();
        CurrentFlight flight = new CurrentFlightBuilder().createCurrentFlight();
        flight.setId(currentFlightId);
        ticketBuilder.setCurrentFlight(flight);
        ticketBuilder.setVip(VIP);

        ticketBuilder.setLagageCapacity(luggage);
        Client client = new ClientBuilder().createClient();
        client.setId(clientID);
        ticketBuilder.setClient(client);

        Integer cost = 0;
        cost += currentFlight.getTicketCost();
        cost += currentFlight.getLagageCost() * luggage;
        ticketBuilder.setFlightCost(cost);
        try {
            ticketDAO.create(ticketBuilder.createTicket());
            return true;
        } catch (PersistExeption throwables) {
            throwables.printStackTrace();
        }
        connectionService.releaseConection();
        return false;
    }
}
