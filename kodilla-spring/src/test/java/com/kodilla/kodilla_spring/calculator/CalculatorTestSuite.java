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
        assertEquals(4, calculator.add(2, 2));
        assertEquals(0, calculator.sub(2, 2));
        assertEquals(4, calculator.mul(2, 2));
        assertEquals(1, calculator.div(2, 2));
    }
}
