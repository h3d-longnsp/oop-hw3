package com.oop.hw3.ex2;

public class FibonacciInt {
    public static void main(String[] args) {
        checkOverflow();
    }

    public static void checkOverflow() {
        int a = 0;
        int b = 0;
        int sum;

        System.out.println("F(0) = 0");

        for (int i = 1; ; i++) {
            // first three numbers in the sequence
            if (a == 0 && b == 0) {
                sum = 1;
            } else {
                sum = a + b;
            }

            if (b > (Integer.MAX_VALUE - a)) {
                System.out.printf("F(%d) is out of range\n", i);
                break;
            }
            a = b;
            b = sum;

            System.out.printf("F(%d) = %d\n", i, sum);
        }
    }
}
