package com.kodilla.kodilla_spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.kodilla_spring");
        Board board = context.getBean(Board.class);
        TaskList toDoList = (TaskList) context.getBean("toDoList");
        TaskList inProgressList = (TaskList) context.getBean("inProgressList");
        TaskList doneList = (TaskList) context.getBean("doneList");
        String task1 = "task1";
        String task2 = "task2";
        String task3 = "task3";

        //When
        toDoList.addTask(task1);
        inProgressList.addTask(task2);
        doneList.addTask(task3);

        //Then
        assertEquals(task1, toDoList.getTask(0));
        assertEquals(task2, inProgressList.getTask(0));
        assertEquals(task3, doneList.getTask(0));

    }
}
