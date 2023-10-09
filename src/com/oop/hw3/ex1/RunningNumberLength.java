package com.oop.hw3.ex1;

public class RunningNumberLength {
    public static void main(String[] args) {
        int input = 3;
        System.out.printf("Length of S(%d) is: %d", input, calculateLength(input));
    }

    public static int calculateLength(int n) {
        if (n == 1) {
            return 1;
        } else {
            return calculateLength(n - 1) + numberOfDigits(n);
        }
    }
    public static int numberOfDigits(int num) {
        if (num == 0) {
            return 0;
        } else {
            return 1 + numberOfDigits(num / 10);
        }
    }
}
