package com.oop.hw3.ex2;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a plain text string: ");
        String plainText = scanner.nextLine().toUpperCase();
        scanner.close();

        String cipherText = encryptCaesarCipher(plainText);

        System.out.println("The cipher text string is: " + cipherText);
    }

    public static String encryptCaesarCipher(String plainText) {
        int shift = 3;
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(character)) {
                char encryptedChar = (char) ((character - 'A' + shift) % 26 + 'A');
                cipherText.append(encryptedChar);
            } else {
                // If it's not a letter, leave it unchanged
                cipherText.append(character);
            }
        }

        return cipherText.toString().toUpperCase();
    }
}
