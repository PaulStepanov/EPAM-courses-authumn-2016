package controller.controlers.filters;


import model.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Setup privileges to specified URI's
 * Exact URI's sets in init method after implementation comment
 */
public class PrivilegesFilter implements Filter {
    private HashMap<Privilege, ArrayList<String>> privilegeMap = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        privilegeMap.put(Privilege.USER, new ArrayList<>());
        privilegeMap.put(Privilege.MODERATOR, new ArrayList<>());
        privilegeMap.put(Privilege.ADMIN, new ArrayList<>());
        //Set urls that need to block
        privilegeMap.get(Privilege.ADMIN).add("/admin/");
        privilegeMap.get(Privilege.USER).add("/user/");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (checkPrivileges(request)) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher errorDispatcher = request.getServletContext().getRequestDispatcher("/error.jsp");
            HttpServletResponse resp = ((HttpServletResponse) response);
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            errorDispatcher.forward(request, resp);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean checkPrivileges(ServletRequest request) {
        String URI = ((HttpServletRequest) request).getRequestURI();
        for (Privilege privilege : privilegeMap.keySet()) {
            ArrayList<String> urls = privilegeMap.get(privilege);
            for (String url : urls) {
                Pattern pattern = Pattern.compile(url);
                Matcher matcher = pattern.matcher(URI);
                if (matcher.find()) {
                    User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
                    if (user == null) {
                        return false;
                    }
                    return user.getPriviligesLvl() >= privilege.getValue();
                }
            }
        }
        return true;
    }
}
