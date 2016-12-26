package controller.controlers;

import controller.controlers.routes.Route;
import controller.controlers.routes.RouteMethod;
import controller.services.UsersService;
import controller.services.UsersServiceIml;
import model.db.ConnectionPoolManager;
import model.domain.User;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginControler extends Controler {
    public LoginControler() {
        super();
        this.addRoute(
                new Route(RouteMethod.POST,
                        "/login",
                        (request, response) -> {
                            String login = request.getParameter("login");
                            String password = request.getParameter("password");
                            UsersService usersService = new UsersServiceIml(new ConnectionPoolManager());
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
