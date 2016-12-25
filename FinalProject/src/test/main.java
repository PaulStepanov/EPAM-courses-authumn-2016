package test;

import model.exeptions.PersistExeption;
import model.parsers.DateTimeParser;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

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
//        System.out.println(DateTimeParser.parseStringTime("2016-12-31 11:30:00"));

        DateTimeFormatter fmt = ISODateTimeFormat.basicTime();
        Duration duration = new Duration(4564564);
        System.out.println(duration.getMillis());
        DateTime dateTime= new DateTime();
        System.out.println(DateTimeParser.parseDateTime(dateTime));;
    }
}
