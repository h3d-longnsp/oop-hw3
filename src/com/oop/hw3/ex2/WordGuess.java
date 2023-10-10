package com.oop.hw3.ex2;

import java.util.Arrays;
import java.util.Scanner;

public class WordGuess {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WordGuess <word_to_guess>");
            return;
        }

        String wordToGuess = args[0];

        initGame(wordToGuess);
    }

    public static void initGame(String keyword) {
        int trials = 0;
        int wordLength = keyword.length();

        char[] guessedWord = new char[wordLength];
        boolean[] guessedLetters = new boolean[wordLength];

        Arrays.fill(guessedWord, '_');
        System.out.printf("Word to guess: %s\n", new String(guessedWord));

        Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.print("Key in one character or your guess word: ");
            String input = scanner.nextLine().toLowerCase();

            // When user guess 1 character
            if (input.length() == 1) {
                trials++;
                char guess = input.charAt(0);

                for (int i = 0; i < wordLength; i++) {
                    if (keyword.charAt(i) == guess && !guessedLetters[i]) {
                        guessedWord[i] = guess;
                        guessedLetters[i] = true;
                    }
                }

                System.out.print("Trial " + trials + ": ");
                System.out.println(new String(guessedWord));

                if (new String(guessedWord).equals(keyword)) {
                    System.out.println("Congratulations! You got it in " + trials + " trials.");
                    break;
                }
            } else if (input.equals(keyword)) { // When user guess the whole word
                trials++;
                System.out.println("Congratulations! You got it in " + trials + " trials.");
                break;
            } else {
                trials++;
                System.out.print("Trial " + trials + ": ");
                System.out.println("Incorrect guess. Try again.");
            }
        }

        scanner.close();
    }
}
