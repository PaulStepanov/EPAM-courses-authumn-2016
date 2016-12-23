package controller.services;

import model.domain.Ticket;
import model.domain.User;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
    List<Ticket> findByUser(User user);
}

