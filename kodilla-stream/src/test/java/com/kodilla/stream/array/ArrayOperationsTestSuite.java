package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        ArrayOperationsImpl arrayOperationsImpl = new ArrayOperationsImpl();

        //When
        double avg1 = arrayOperationsImpl.getAverage(new int[]{});
        double avg2 = arrayOperationsImpl.getAverage(new int[]{5});
        double avg3 = arrayOperationsImpl.getAverage(new int[]{1, 2, 4});

        //Then
        assertEquals(0.0, avg1);
        assertEquals(5.0, avg2);
        assertEquals(2.333, avg3, 0.001);
    }
}
