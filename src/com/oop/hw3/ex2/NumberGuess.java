package com.oop.hw3.ex2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        initGame();
    }

    public static void initGame() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100); // Generate a random number between 0 and 99
        int numberOfTries = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("A random number has been selected between 0 and 99. Try to guess it.");

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfTries++;

            if (userGuess < randomNumber) {
                System.out.println("Try higher.");
            } else if (userGuess > randomNumber) {
                System.out.println("Try lower.");
            } else {
                System.out.printf("You got it in %d trials.\n", numberOfTries);
                break; // Exit the loop when the user guesses correctly
            }
        }

        scanner.close();
    }
}
