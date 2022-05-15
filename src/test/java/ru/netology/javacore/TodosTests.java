package ru.netology.javacore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TodosTests {

    Todos sut;

    @BeforeEach
    public void init() {
        sut = new Todos();
    }

    @Test
    public void testTodos_add() {
        String task1 = "Погулять с собакой";
        String task2 = "Выучить JavaCore";
        String expected = "Выучить JavaCore Погулять с собакой";

        sut.addTask(task1);
        sut.addTask(task2);
        String result = sut.getAllTasks();

        assertThat(result, equalTo(expected));
    }

    @Test
    public void testTodos_remove() {
        String task1 = "Погулять с собакой";
        String task2 = "Выучить JavaCore";
        String expected = "Выучить JavaCore";

        sut.addTask(task1);
        sut.addTask(task2);
        sut.removeTask("Погулять с собакой");
        String result = sut.getAllTasks();

        assertThat(result, equalTo(expected));
    }

    @Test
    public void testTodos_getAllTasks() {
        String task1 = "Пробежка";
        String task2 = "Акробатика";
        String task3 = "Учёба";
        String expected = "Акробатика Пробежка Учёба";

        sut.addTask(task1);
        sut.addTask(task2);
        sut.addTask(task3);
        String result = sut.getAllTasks();

        assertThat(result, equalTo(expected));
    }
}
