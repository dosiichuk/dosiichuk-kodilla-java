package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("Test 1 OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int addResult = calculator.add(8, 7);
        int subtractResult = calculator.subtract(30, 15);

        if (addResult == 15) {
            System.out.println("Test 2 OK");
        } else {
            System.out.println("Error!");
        }

        if (subtractResult == 15) {
            System.out.println("Test 3 OK");
        } else {
            System.out.println("Error!");
        }
    }
}