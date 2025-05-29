package com.kodilla.kodilla_project_patterns.aop.calculator;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CalculatorTestSuite {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Autowired
    private Calculator calculator;

    @Test
    void testAdd() {
        //Given
        //When
        double result = calculator.add(10, 15);
        //Then
        LOGGER.info(() ->"Testing add method");
        assertEquals(25, result, 0);
    }
    @Test
    void testSub() {
        //Given
        //When
        double result = calculator.sub(10, 15);
        //Then
        LOGGER.info(() -> "Testing sub method");
        assertEquals(-5, result, 0);
    }
    @Test
    void testMul() {
        //Given
        //When
        double result = calculator.mul(10, 15);
        //Then
        LOGGER.info(() -> "Testing mul method");
        assertEquals(150, result, 0);
    }
    @Test
    void testDiv() {
        //Given
        //When
        double result = calculator.div(15, 5);
        //Then
        LOGGER.info(() -> "Testing div method");
        assertEquals(3, result, 0);
    }

    @Test
    void testFactorial() {
        BigDecimal result = calculator.factorial(new BigDecimal(1000));

        LOGGER.info(() -> "Testing factorial");
        System.out.println(result);
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }

}
