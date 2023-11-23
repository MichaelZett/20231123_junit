package de.zettsystems;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private final List<String> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public boolean addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            return false;
        }
        return tasks.add(task);
    }

    public boolean removeTask(String task) {
        return tasks.remove(task);
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    public boolean isTaskPresent(String task) {
        return tasks.contains(task);
    }

    public int getTaskCount() {
        return tasks.size();
    }
}