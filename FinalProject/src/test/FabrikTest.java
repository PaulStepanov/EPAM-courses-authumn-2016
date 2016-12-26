package test;

import model.DAO.FabricMySADA;
import model.DAO.TicketDAO;

/**
 * Created by frees on 21.12.2016.
 */
public class FabrikTest {
    public static void main(String... args) {
//        FabricMySADA.getDAO(model.DAO.CityDAO.class);
//        FabricMySADA.getDAO(FlightDAO.class);
//        FabricMySADA.getDAO(CurrentFlight.class);
//        FabricMySADA.getDAO(UserDAO.class);
        FabricMySADA.getDAO(TicketDAO.class);
    }
}
