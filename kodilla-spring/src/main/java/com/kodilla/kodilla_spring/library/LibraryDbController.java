package com.kodilla.kodilla_spring.library;


import org.springframework.stereotype.Repository;

@Repository
public class LibraryDbController {

    public void saveData() {
        System.out.println("Saving data to teh database.");
    }

    public void loadData() {
        System.out.println("Loading data from the database.");
    }
}
