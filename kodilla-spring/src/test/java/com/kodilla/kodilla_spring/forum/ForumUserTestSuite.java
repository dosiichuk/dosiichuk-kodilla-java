package com.kodilla.kodilla_spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ForumUserTestSuite {

    @Test
    void testGetUserName() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.kodilla_spring.forum");
        ForumUser user = context.getBean(ForumUser.class);
        //When
        String name = user.getName();

        //Then
        assertEquals("John Smith", name);
    }
}
