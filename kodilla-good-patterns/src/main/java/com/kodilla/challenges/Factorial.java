package com.kodilla.challenges;

public class Factorial {

    public static int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number must be greater than or equal to 0.");
        }
        if (n == 0) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(calculateFactorial(5));
    }
}
