package model.DAO;

import model.domain.Ticket;

import java.util.List;

public interface TicketDAO extends DBDAO<Ticket> {
    public List<Ticket> findAll();
}
