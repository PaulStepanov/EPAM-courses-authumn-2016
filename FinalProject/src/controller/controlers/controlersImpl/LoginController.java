package controller.controlers.controlersImpl;

import controller.controlers.Controller;
import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import controller.services.ServiceManager;
import controller.services.UsersService;
import model.domain.User;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends Controller {
    public LoginController() {
        super();
        this.addRoute(
                new Route(RouteMethod.POST,
                        "/login",
                        (request, response) -> {
                            String login = request.getParameter("login");
                            String password = request.getParameter("password");
                            UsersService usersService = (UsersService) ServiceManager.getService(UsersService.class);
                            User user = usersService.getByLoginAndPassword(login, password);
                            request.getSession().setAttribute("user", user);
                            if (user != null) {
                                try {
                                    response.setContentType("text/plain");
                                    final PrintWriter write = response.getWriter();
                                    write.append("signed");
                                    write.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }));
        this.addRoute(
                new Route(RouteMethod.GET,
                        "/logout",
                        (request, response) -> request.getSession().setAttribute("user", null)
                ));
    }
}
