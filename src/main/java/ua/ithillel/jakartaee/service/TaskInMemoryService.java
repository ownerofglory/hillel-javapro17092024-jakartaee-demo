package ua.ithillel.jakartaee.service;

import ua.ithillel.jakartaee.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskInMemoryService implements TaskService {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }
}
