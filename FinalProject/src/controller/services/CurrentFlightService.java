package controller.services;

import model.domain.CurrentFlight;

import java.util.List;

public interface CurrentFlightService {
    CurrentFlight find(Integer id);

    List<CurrentFlight> findAll();
}
