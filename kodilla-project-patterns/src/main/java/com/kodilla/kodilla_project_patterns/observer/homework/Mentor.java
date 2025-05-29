package com.kodilla.kodilla_project_patterns.observer.homework;

public class Mentor implements Observer{
    private String name;
    private int notificationCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        notificationCount++;
        System.out.println("You have received an update from the course participant!");
    }

    public int getNotificationCount() {
        return notificationCount;
    }
}
