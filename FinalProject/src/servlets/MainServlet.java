package servlets;

import DAO.CityMySQLDAO;
import DAO.FlightMySQLDAO;
import DAO.UserMySQLDAO;
import db.ConectionManager;
import exeptions.PersistExeption;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Павел on 30-Nov-16.
 */

@WebServlet("/")
public class MainServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("html");
        PrintWriter write=response.getWriter();
            ConectionManager conectionManager = new ConectionManager();
            CityMySQLDAO cityMySQLDAO = new CityMySQLDAO(conectionManager.getConnection());
        try {
            cityMySQLDAO.read(1);
            FlightMySQLDAO flightMySQLDAO = new FlightMySQLDAO(cityMySQLDAO,conectionManager.getConnection());
            flightMySQLDAO.read(1);
            UserMySQLDAO userMySQLDAO = new UserMySQLDAO(conectionManager.getConnection());
            userMySQLDAO.read(3);
            write.append(userMySQLDAO.read(3).getLogin());
        } catch (PersistExeption throwables) {
            throwables.printStackTrace();
        }
        write.flush();
    }
}
