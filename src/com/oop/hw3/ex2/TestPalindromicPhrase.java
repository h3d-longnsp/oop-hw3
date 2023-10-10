package com.oop.hw3.ex2;

import java.util.Scanner;

public class TestPalindromicPhrase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a phrase: ");
        String input = scanner.nextLine();
        scanner.close();

        if (isPalindromicPhrase(input)) {
            System.out.printf("\"%s\" is a palindrome.\n", input);  // "Was it a car or a cat I saw?" is a palindrome
        } else {
            System.out.printf("\"%s\" is not a palindrome.\n", input); // "This is not a palindrome" is not a palindrome
        }
    }

    public static boolean isPalindromicPhrase(String phrase) {
        // Convert the phrase to lowercase to ignore capitalization
        phrase = phrase.toLowerCase();

        // Remove all non-alphanumeric characters (including spaces and punctuation)
        phrase = phrase.replaceAll("[^a-zA-Z0-9]", "");

        int left = 0;
        int right = phrase.length() - 1;

        while (left < right) {
            if (phrase.charAt(left) != phrase.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
