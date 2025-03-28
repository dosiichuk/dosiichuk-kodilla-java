package com.kodilla.kodilla_project_patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(String taskClass) {
        return switch(taskClass) {
            case SHOPPING_TASK -> new ShoppingTask("Shopping", "Groceries", 2.0);
            case PAINTING_TASK -> new PaintingTask("Painting", "White", "Room");
            case DRIVING_TASK -> new DrivingTask("Driving", "Home", "Car");
            default -> null;
        };
    }

}
