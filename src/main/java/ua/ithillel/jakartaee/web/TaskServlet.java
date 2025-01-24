package ua.ithillel.jakartaee.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import ua.ithillel.jakartaee.model.Task;
import ua.ithillel.jakartaee.service.TaskService;

import java.io.IOException;
import java.util.List;

public class TaskServlet extends HttpServlet {
    private final TaskService taskService;

    public TaskServlet(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> allTasks = taskService.getAllTasks();

        req.setAttribute("tasks", allTasks);

        req.getRequestDispatcher("task-app.jsp")
                .include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskName = req.getParameter("task");
        Task task = new Task();
        task.setName(taskName);

        taskService.addTask(task);

        resp.sendRedirect(req.getContextPath() + "/task");
    }
}
