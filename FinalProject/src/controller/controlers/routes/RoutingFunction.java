package controller.controlers.routes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface RoutingFunction {
    void exec(HttpServletRequest request, HttpServletResponse response);
}
