package com.kodilla.kodilla_spring.library;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    void testLoadFromDb() {
        //Given
        //When
        library.loadFromDb();

        //Then
        //Do nothing
    }

    @Test
    void testSaveToDb() {
        //Given
        //When
        library.saveToDb();

        //Then
        //do nothing
    }

    @Test
    void testContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        System.out.println("===Beans list===");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("===Beans list===");
    }

    @Test
    void testContext1() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
