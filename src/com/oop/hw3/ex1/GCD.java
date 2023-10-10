package com.oop.hw3.ex1;

public class GCD {
    public static void main(String[] args) {
        int a = 48;
        int b = 56;
        System.out.printf("The greatest common divisor of %d and %d is %d.\n", a, b, gcd(a, b)); // gcd(48, 56) = 8
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
