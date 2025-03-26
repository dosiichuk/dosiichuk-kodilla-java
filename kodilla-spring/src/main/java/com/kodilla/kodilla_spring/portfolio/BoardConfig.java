package com.kodilla.kodilla_spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean(name = "toDoList")
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    public TaskList inProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    public TaskList doneList() {
        return new TaskList();
    }

    @Bean
    public Board board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        return new Board(toDoList, inProgressList, doneList);
    }
}
