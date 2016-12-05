package model.DAO;

import model.domain.Ticket;

import java.util.List;

public interface TicketDAO extends DAO<Ticket> {
    public List<Ticket> findAll();
}
