package com.kodilla.kodilla_project_patterns.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskQueueTestSuite {

    @Test
    void testUpdate() {
        TaskQueue taskQueue = new TaskQueue("Test student");
        Mentor mentor = new Mentor("Test mentor");
        taskQueue.registerObserver(mentor);

        taskQueue.addTaskToQueue("Task 1");
        taskQueue.addTaskToQueue("Task 2");

        assertEquals(2, mentor.getNotificationCount());
    }
}
