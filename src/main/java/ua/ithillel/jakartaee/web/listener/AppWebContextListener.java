package ua.ithillel.jakartaee.web.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ua.ithillel.jakartaee.service.TaskInMemoryService;
import ua.ithillel.jakartaee.service.TaskService;
import ua.ithillel.jakartaee.web.TaskServlet;

//@WebListener
public class AppWebContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        TaskService service = new TaskInMemoryService();

        ServletContext servletContext = sce.getServletContext();

        TaskServlet taskServlet = new TaskServlet(service);

        servletContext.addServlet("taskServlet", taskServlet)
                .addMapping("/task");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
