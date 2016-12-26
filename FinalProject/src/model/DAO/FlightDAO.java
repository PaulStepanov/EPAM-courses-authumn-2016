package model.DAO;

import model.domain.Flight;

import java.util.List;

public interface FlightDAO extends DBDAO<Flight> {
    List<Flight> findAll();
}

