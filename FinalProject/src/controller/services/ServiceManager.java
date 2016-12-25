package controller.services;

import model.db.ConnectionManager;
import model.db.ConnectionPoolManager;

import java.util.HashMap;

/**
 * Created by frees on 19.12.2016.
 */
public class ServiceManager {
    private static ServiceManager instance = new ServiceManager();
    private HashMap<Class, Object> map = new HashMap<>();

    private ServiceManager() {
        ConnectionManager connectionManager = new ConnectionPoolManager();
        this.map.put(FlightService.class, new FlightServiceImp(connectionManager));
        this.map.put(TicketService.class, new TicketServiceImpl(connectionManager) {});
        this.map.put(UsersService.class, new UsersServiceIml(connectionManager));
        this.map.put(CurrentFlightService.class, new CurrentFlightServiceImpl(connectionManager));
    }

    public static Object getService(Class servClass) {
        return instance.map.get(servClass);
    }
}
