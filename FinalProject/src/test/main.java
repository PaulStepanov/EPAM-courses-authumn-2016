package test;

import exeptions.PersistExeption;
import parsers.DateTimeParser;

/**
 * Created by Павел on 28-Nov-16.
 */
public class main {
    public static void main(String... args) throws PersistExeption {
//        ConnectionPoolManager connectionPoolManager = new ConnectionPoolManager();
//        CityMySQLDAO cityMySQLDAO = new CityMySQLDAO(connectionPoolManager.getConnection());
//        cityMySQLDAO.read(1);
//        FlightMySQLDAO flightMySQLDAO = new FlightMySQLDAO(cityMySQLDAO, connectionPoolManager.getConnection());
//        flightMySQLDAO.read(1);
//        UserMySQLDAO userMySQLDAO = new UserMySQLDAO(connectionPoolManager.getConnection());
//        userMySQLDAO.read(3);
//        System.out.println(userMySQLDAO.read(3).getEmail());
//        System.out.println("hello");
        System.out.println(DateTimeParser.parse("2016-12-31 11:30:00"));;
    }
}
