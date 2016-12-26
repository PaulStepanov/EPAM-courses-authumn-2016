package controller.controlers.routes;

public class Route {
    private String URI;
    private RouteMethod method;
    private RoutingFunction routingFunction;

    public Route(RouteMethod method, String URI, RoutingFunction routingFunction) {
        this.method = method;
        this.URI = URI;
        this.routingFunction = routingFunction;
    }

    public String getURI() {
        return URI;
    }

    public RouteMethod getMethod() {
        return method;
    }

    public RoutingFunction getRoutingFunction() {
        return routingFunction;
    }
}
