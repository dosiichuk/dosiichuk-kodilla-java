package com.kodilla.kodilla_spring.calculator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //When
        //Then
        assertEquals(calculator.add(2, 2), 4);
        assertEquals(calculator.sub(2, 2), 0);
        assertEquals(calculator.mul(2, 2), 4);
        assertEquals(calculator.div(2, 2), 1);
    }
}
