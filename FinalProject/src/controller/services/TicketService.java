package controller.services;

import model.domain.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
}

