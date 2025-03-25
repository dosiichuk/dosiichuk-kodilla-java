package com.kodilla.kodilla_spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Display {

    public void displayValue(double val) {
        System.out.println("The value is: " + val);
    }
}
