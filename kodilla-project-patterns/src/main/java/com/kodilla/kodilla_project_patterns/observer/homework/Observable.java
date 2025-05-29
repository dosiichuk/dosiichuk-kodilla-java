package com.kodilla.kodilla_project_patterns.observer.homework;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObservers();
    void removeObserver(Observer observer);
}
