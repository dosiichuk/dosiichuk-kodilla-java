package com.kodilla.kodilla_project_patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //given
        //creating the list of sample books
        Book book1 = new Book("A", "Author1", LocalDate.of(2000, 1, 1));
        Book book2 = new Book("B", "Author2", LocalDate.of(2001, 2, 2));
        Book book3 = new Book("C", "Author3", LocalDate.of(2002, 3, 3));

        //creating a new libary instance
        Library library1 = new Library();
        library1.setName("Library1");
        library1.getBooks().add(book1);
        library1.getBooks().add(book2);
        library1.getBooks().add(book3);

        //cloning the library
        Library clonedLibrary = null;
        try {
            clonedLibrary = library1.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library1.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        //When
        library1.getBooks().remove(book1);

        //Then
        System.out.println(library1);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(2, library1.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), library1.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), clonedLibrary.getBooks());

    }
}
