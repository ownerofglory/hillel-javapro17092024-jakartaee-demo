package ua.ithillel.jakartaee.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.soap.SOAPException;
import ua.ithillel.jakartaee.model.Task;
import ua.ithillel.jakartaee.model.TaskList;
import ua.ithillel.jakartaee.service.TaskInMemoryService;
import ua.ithillel.jakartaee.service.TaskService;

import java.util.List;

@WebService(targetNamespace = "http://ws.jakartaee.ithillel.ua")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class TaskSOAPService {
    // TODO: use dependency injection
    private TaskService taskService = new TaskInMemoryService();

    @WebMethod
    public TaskList getTaskList() {
        List<Task> allTasks = taskService.getAllTasks();
        TaskList taskList = new TaskList();
        taskList.setTasks(allTasks);
        return taskList;
    }

    @WebMethod
    public void addTask(@WebParam(name = "task") Task task) {
        taskService.addTask(task);
    }
}
