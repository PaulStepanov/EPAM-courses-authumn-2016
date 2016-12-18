package model.DAO;

import model.domain.Flight;

import java.util.List;

public interface FlightDAO extends DAO<Flight> {
    public List<Flight> findAll();
}

