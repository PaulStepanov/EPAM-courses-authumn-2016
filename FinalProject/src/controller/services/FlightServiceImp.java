package controller.services;

import controller.services.connection.ConnectionServiceControl;
import model.DAO.FabricMySADA;
import model.DAO.FlightDAO;
import model.db.ConnectionManager;
import model.domain.Flight;

import java.util.List;

class FlightServiceImp implements FlightService {
    FlightDAO flightDAO;
    ConnectionManager connectionManager;
    ConnectionServiceControl connectionService;

    FlightServiceImp(ConnectionManager connectionManager) {
        flightDAO = (FlightDAO) new FabricMySADA().createDAO(FlightDAO.class);
        this.connectionManager = connectionManager;
        this.connectionService = new ConnectionServiceControl(flightDAO);
    }

    @Override
    public List<Flight> findAll() {
        connectionService.setConnection(connectionManager.getConnection());
        List<Flight> result = flightDAO.findAll();
        connectionService.releaseConection();
        return result;
    }
}
