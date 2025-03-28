package com.kodilla.testing.loop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopAndConditionalBreakpointsTestSuite {

    @Test
    void testLoop() {
        //given
        long sum = 0;
        //When
        for (int n = 0; n < 1000; n++) {
            sum += n;
            System.out.println("[" + n + "] sum equals: " + sum);
        }

        //Then
        assertEquals(499500, sum);
    }
}
