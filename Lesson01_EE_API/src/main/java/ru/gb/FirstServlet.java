package ru.gb;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(name = "FirstServlet", urlPatterns = "/first_servlet")
public class FirstServlet implements Servlet {

    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().println("<h1>Hello from FirstServlet</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
