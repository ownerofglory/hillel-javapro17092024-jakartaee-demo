package ua.ithillel.jakartaee.service;

import ua.ithillel.jakartaee.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    void addTask(Task task);
}
