package controller.servlets;

import controller.services.TicketServiceImpl;
import model.DAO.*;
import model.db.ConnectionPoolManager;
import model.exeptions.PersistExeption;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    /*Testing*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("html");
        final PrintWriter write = response.getWriter();
        ConnectionPoolManager connectionPoolManager = new ConnectionPoolManager();
        CityMySQLDAO cityMySQLDAO = new CityMySQLDAO(connectionPoolManager.getConnection());
        try {
            cityMySQLDAO.read(1);
            FlightMySQLDAO flightMySQLDAO = new FlightMySQLDAO(cityMySQLDAO, connectionPoolManager.getConnection());
            write.append(flightMySQLDAO.read(1).getFlightTime().toString());
            UserMySQLDAO userMySQLDAO = new UserMySQLDAO(connectionPoolManager.getConnection());
            userMySQLDAO.read(3);
            write.append(userMySQLDAO.read(3).getLogin());
            CurrentFlightMySQLDAO currentFlightMySQLDAO = new CurrentFlightMySQLDAO(flightMySQLDAO, connectionPoolManager.getConnection());
            HttpSession session = request.getSession();
            session.setAttribute("Login", "hi" + session.getId());
            write.append(session.getAttribute("Login").toString() + "\n");
            write.append(currentFlightMySQLDAO.read(2).getTicket_cost().toString() + "\n");
            ClientMySQLDAO clientMySQLDAO = new ClientMySQLDAO(userMySQLDAO, connectionPoolManager.getConnection());
            write.append(clientMySQLDAO.read(1).getName() + "\n");
            TicketMySQLDAO ticketMySQLDAO = new TicketMySQLDAO(clientMySQLDAO, currentFlightMySQLDAO, connectionPoolManager.getConnection());
            write.append(ticketMySQLDAO.read(2).getFlightCost().toString() + "\n");
            TicketServiceImpl ticketService = new TicketServiceImpl(new ConnectionPoolManager());
            ticketService.findAll().forEach(elem -> {
                write.append(elem.getFlightCost().toString() + "\n");
            });

        } catch (PersistExeption throwables) {
            throwables.printStackTrace();
        }
        write.flush();
    }
}
