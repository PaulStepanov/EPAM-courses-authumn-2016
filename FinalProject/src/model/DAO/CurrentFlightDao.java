package model.DAO;

import model.domain.CurrentFlight;

import java.util.List;


public interface CurrentFlightDao extends DBDAO<CurrentFlight> {
    List<CurrentFlight> findAll();
}
