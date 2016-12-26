package controller.services;

import model.domain.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();

    List<Ticket> findByUser(Integer userId);

    boolean registerTicket(Integer currentFlightId, Integer luggage, boolean VIP, Integer clientID);
}

