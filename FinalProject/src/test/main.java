package test;

import DAO.CityMySQLDAO;
import DAO.FlightMySQLDAO;
import DAO.UserMySQLDAO;
import db.ConectionManager;
import exeptions.PersistExeption;

/**
 * Created by Павел on 28-Nov-16.
 */
public class main {
    public static void main(String... args) throws PersistExeption {
        ConectionManager conectionManager = new ConectionManager();
        CityMySQLDAO cityMySQLDAO = new CityMySQLDAO(conectionManager.getConnection());
        cityMySQLDAO.read(1);
        FlightMySQLDAO flightMySQLDAO = new FlightMySQLDAO(cityMySQLDAO,conectionManager.getConnection());
        flightMySQLDAO.read(1);
        UserMySQLDAO userMySQLDAO = new UserMySQLDAO(conectionManager.getConnection());
        userMySQLDAO.read(3);
        System.out.println(userMySQLDAO.read(3).getEmail());
        System.out.println("hello");
    }
}
