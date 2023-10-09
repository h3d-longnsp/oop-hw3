package com.oop.hw3.ex2;

import java.util.Scanner;

public class ExchangeCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a plain text string: ");
        String plaintext = scanner.nextLine().toUpperCase();
        scanner.close();

        System.out.println("The cipher text string is: " + exchangeCharacters(plaintext));
    }

    public static String exchangeCharacters(String plainText) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(character)) {
                char encryptedChar = (char) ('Z' - (character - 'A'));
                cipherText.append(encryptedChar);
            } else {
                // If it's not a letter, leave it unchanged
                cipherText.append(character);
            }
        }
        return cipherText.toString().toUpperCase();
    }
}
