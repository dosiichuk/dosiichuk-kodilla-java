package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        String testMethodName = testInfo.getDisplayName();
        System.out.println("Description of test case: " + testMethodName);
    }

    @DisplayName("Given an empty list, OddNumberExterminator.exterminate() should return an empty list")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumberExterminator oddNumbersExterminator = new OddNumberExterminator();
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(List.of());
        //Then
        Assertions.assertTrue(result.isEmpty());
    }

    @DisplayName("Given a list with even and odd numbers, OddNumberExterminator.exterminate() should return a list with only even numbers")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumberExterminator oddNumbersExterminator = new OddNumberExterminator();
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        //Then
        Assertions.assertEquals(List.of(2, 4, 6, 8, 10), result);
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        String testMethodName = testInfo.getDisplayName();
        System.out.println("Test case completed: " + testMethodName);
    }
}
