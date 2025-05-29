package com.kodilla.kodilla_project_patterns.observer.homework;



import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements Observable {
    private String studentName;
    private List<String> tasks;
    private List<Observer> observers;

    public TaskQueue(String studentName) {
        this.studentName = studentName;
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addTaskToQueue(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
