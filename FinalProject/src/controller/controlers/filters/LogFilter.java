package controller.controlers.filters;

import model.logger.Log4jLogger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Logging type of method,request URI than logs response status
 * Example: GET /html/availableFlightsstatus:200
 */
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Log4jLogger.log("-----Loggin started------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        Log4jLogger.log(httpRequest.getMethod() + " " + httpRequest.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        Integer respStat = ((HttpServletResponse) servletResponse).getStatus();
        Log4jLogger.log(httpRequest.getMethod() + " " + httpRequest.getRequestURI() + "status:" + respStat);
    }

    @Override
    public void destroy() {
        Log4jLogger.log("-----Loggin finished-----");
    }
}
