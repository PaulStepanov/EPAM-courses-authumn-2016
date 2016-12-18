package controller.services;

import model.domain.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findAll();
}
