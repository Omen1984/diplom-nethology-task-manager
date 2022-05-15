package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    List<String> todos;
    
    public Todos() {
        todos = new ArrayList<>();
    }

    public void addTask(String task) {
        todos.add(task);
    }

    public void removeTask(String task) {
        todos.remove(task);
    }

    public String getAllTasks() {
        return todos.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));
    }

}
