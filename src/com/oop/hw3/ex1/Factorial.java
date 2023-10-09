package com.oop.hw3.ex1;

public class Factorial {
    public static void main(String[] args) {
        int input = 11;
        System.out.printf("Factorial of %d is %d.\n", input, factorial(input));
    }

    public static int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}