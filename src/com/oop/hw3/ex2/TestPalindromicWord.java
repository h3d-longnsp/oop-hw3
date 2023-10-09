package com.oop.hw3.ex2;

import java.util.Scanner;

public class TestPalindromicWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = scanner.nextLine();
        scanner.close();

        if (isPalindromicWord(input)) {
            System.out.printf("%s is a palindrome.\n", input);  // tacoCAT is a palindrome
        } else {
            System.out.printf("%s is not a palindrome.\n", input); // testing is not a palindrome
        }
    }

    public static boolean isPalindromicWord(String word) {
        // Convert the word to lowercase to ignore capitalization
        word = word.toLowerCase();

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
