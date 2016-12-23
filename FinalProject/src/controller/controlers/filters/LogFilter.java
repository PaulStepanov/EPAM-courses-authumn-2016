package controller.controlers.filters;

import model.logger.Log4jLogger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by frees on 16.12.2016.
 */


public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Log4jLogger.log("-----Loggin started------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        //TODO replace with stringbuilder
        Log4jLogger.log(httpRequest.getMethod()+" "+httpRequest.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Log4jLogger.log("-----Loggin finished-----");
    }
}
