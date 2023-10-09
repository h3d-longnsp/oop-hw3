package com.oop.hw3.ex1;

public class Fibonacci {
    public static void main(String[] args) {
        int input = 2;
        System.out.printf("F(%d) = %d.\n", input, fibonacci(input));
    }

    public static int fibonacci(long number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
