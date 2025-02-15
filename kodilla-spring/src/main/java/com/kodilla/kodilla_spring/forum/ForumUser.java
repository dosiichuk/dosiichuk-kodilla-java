package com.kodilla.kodilla_spring.forum;


import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    private final String name;

    public ForumUser() {
        this.name = "John Smith";
    }

    public String getName() {
        return name;
    }
}
