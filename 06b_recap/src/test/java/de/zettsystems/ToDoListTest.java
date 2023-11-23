package de.zettsystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {
    private ToDoList toDoList;

    @BeforeEach
    void setUp() {
        toDoList = new ToDoList();
    }

    @Test
    void testAddTask() {
        assertTrue(toDoList.addTask("Einkaufen gehen"));
        assertFalse(toDoList.addTask(""));
        assertFalse(toDoList.addTask(null));
    }

    @Test
    void testRemoveTask() {
        toDoList.addTask("Einkaufen gehen");
        assertTrue(toDoList.removeTask("Einkaufen gehen"));
        assertFalse(toDoList.removeTask("Sport machen"));
    }

    @Test
    void testGetTasks() {
        toDoList.addTask("Einkaufen gehen");
        toDoList.addTask("Sport machen");
        assertEquals(2, toDoList.getTasks().size());
        assertTrue(toDoList.getTasks().contains("Einkaufen gehen"));
        assertTrue(toDoList.getTasks().contains("Sport machen"));
    }

    @Test
    void testIsTaskPresent() {
        toDoList.addTask("Einkaufen gehen");
        assertTrue(toDoList.isTaskPresent("Einkaufen gehen"));
        assertFalse(toDoList.isTaskPresent("Sport machen"));
    }

    @Test
    void testGetTaskCount() {
        assertEquals(0, toDoList.getTaskCount());
        toDoList.addTask("Einkaufen gehen");
        assertEquals(1, toDoList.getTaskCount());
    }
}