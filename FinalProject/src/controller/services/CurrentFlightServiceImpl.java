package controller.services;

import controller.services.connection.ConnectionServiceControl;
import model.DAO.CurrentFlightDao;
import model.DAO.FabrikMySQLDAO;
import model.db.ConnectionManager;
import model.domain.CurrentFlight;
import model.exeptions.PersistExeption;

import java.util.ArrayList;
import java.util.List;

public class CurrentFlightServiceImpl implements CurrentFlightService {
    CurrentFlightDao currentFlightDao;
    ConnectionManager connectionManager;
    ConnectionServiceControl connectionService;

    public CurrentFlightServiceImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        this.currentFlightDao = (CurrentFlightDao) FabrikMySQLDAO.getDAO(CurrentFlightDao.class);
        this.connectionService=new ConnectionServiceControl(currentFlightDao);
    }

    @Override
    public CurrentFlight find(Integer id) {
        connectionService.setConnection(connectionManager.getConnection());
        CurrentFlight res=null;
        try {
            res= this.currentFlightDao.read(id);
        } catch (PersistExeption throwables) {
            throwables.printStackTrace();
        }
        connectionService.releaseConection();
        return res;
    }

    @Override
    public List<CurrentFlight> findAll() {
        connectionService.setConnection(connectionManager.getConnection());
        ArrayList res= (ArrayList) this.currentFlightDao.findAll();
        connectionService.releaseConection();
        return res;
    }
}
