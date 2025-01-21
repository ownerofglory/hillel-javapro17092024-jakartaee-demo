package ua.ithillel.jakartaee.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.jakartaee.service.HelloService;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private HelloService helloService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("HelloServlet init");

        helloService = new HelloService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet incoming request");

        if (req.getQueryString() != null) {
            String queryString = req.getQueryString();
            String[] strings = queryString.split("=");
            if (strings.length == 2) {
                String name = strings[1];

                String result = helloService.sayHello(name);
                resp.setContentType("text/plain");
                resp.getWriter().write(result);
                resp.getWriter().flush();
                return;
            }
        }

        String result = helloService.sayHello();

        resp.setContentType("text/plain");
        resp.getWriter().println(result);
        resp.getWriter().flush();
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet destroy");

        helloService = null;
    }
}
