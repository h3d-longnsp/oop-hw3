package com.oop.hw3.ex2;

public class FactorialInt {
    public static void main(String[] args) {
        checkOverflow();
    }

    public static void checkOverflow() {
        int number = 1;
        int factorial = 1;

        while (true) {
            // Check if the next factorial will exceed the integer range
            if (Integer.MAX_VALUE / factorial < (number + 1)) {
                System.out.printf("The factorial of %d is out of range.\n", number);
                break;
            }

            // Calculate the next factorial
            factorial *= number;

            // Print the factorial if it's within the integer range
            System.out.printf("The factorial of %d is %d.\n", number, factorial);

            number++;
        }
    }
}