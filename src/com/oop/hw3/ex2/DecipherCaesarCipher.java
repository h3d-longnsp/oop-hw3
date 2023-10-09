package com.oop.hw3.ex2;

import java.util.Scanner;

public class DecipherCaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a cipher text string: ");
        String cipherText = scanner.nextLine().toUpperCase();
        scanner.close();

        String plainText = decryptCaesarCipher(cipherText);

        System.out.println("The plain text string is: " + plainText.toUpperCase());
    }

    public static String decryptCaesarCipher(String cipherText) {
        int shift = 3;
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char character = cipherText.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(character)) {
                char decryptedChar = (char) ((character - 'A' - shift + 26) % 26 + 'A');
                plainText.append(decryptedChar);
            } else {
                // If it's not a letter, leave it unchanged
                plainText.append(character);
            }
        }

        return plainText.toString().toUpperCase();
    }
}
