package test;

import model.DAO.FabrikMySQLDAO;
import model.DAO.FlightDAO;
import model.DAO.TicketDAO;
import model.DAO.UserDAO;
import model.domain.CurrentFlight;

/**
 * Created by frees on 21.12.2016.
 */
public class FabrikTest {
    public static void main(String... args) {
//        FabrikMySQLDAO.getDAO(model.DAO.CityDAO.class);
//        FabrikMySQLDAO.getDAO(FlightDAO.class);
//        FabrikMySQLDAO.getDAO(CurrentFlight.class);
//        FabrikMySQLDAO.getDAO(UserDAO.class);
        FabrikMySQLDAO.getDAO(TicketDAO.class);
    }
}
