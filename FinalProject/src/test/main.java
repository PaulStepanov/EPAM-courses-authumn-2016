package test;

import DAO.CityMySQLDAO;
import DAO.FlightMySQLDAO;
import db.ConectionManager;
import exeptions.PersistExeption;

/**
 * Created by Павел on 28-Nov-16.
 */
public class main {
    public static void main(String... args) throws PersistExeption {
        ConectionManager conectionManager = new ConectionManager();
        ;
        CityMySQLDAO cityMySQLDAO = new CityMySQLDAO(conectionManager.getConnection());
        cityMySQLDAO.read(1);
        FlightMySQLDAO flightMySQLDAO = new FlightMySQLDAO(cityMySQLDAO,conectionManager.getConnection());
        flightMySQLDAO.read(1);
    }
}
