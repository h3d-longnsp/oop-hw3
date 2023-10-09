package com.oop.hw3.ex2;

import java.util.Arrays;
import java.util.Scanner;

public class GradesStatistics {
    public static int[] grades;

    public static void main(String[] args) {
        readGrades();
        // Calculate and display the statistics
        System.out.println("The grades are: " + Arrays.toString(grades));
        System.out.printf("The average is: %.2f%n", average(grades));
        System.out.printf("The median is : %.2f%n", median(grades));
        System.out.printf("The minimum is: %d", min(grades));
        System.out.printf("The maximum is: %d", max(grades));
        System.out.printf("The standard deviation is: %.2f%n", std(grades));
    }

    public static void readGrades() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        grades = new int[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("Enter the grade for student %d: ", i + 1);
            grades[i] = scanner.nextInt();
        }

        scanner.close();
    }

    // Calculate the average of the grades
    private static double average(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // Calculate the median of the grades
    private static double median(int[] grades) {
        Arrays.sort(grades);
        int middle = grades.length / 2;
        if (grades.length % 2 == 0) {
            return (double) (grades[middle - 1] + grades[middle]) / 2;
        } else {
            return grades[middle];
        }
    }

    // Calculate the minimum of the grades
    private static int min(int[] grades) {
        int min = grades[0];
        for (int grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    // Calculate the maximum of the grades
    private static int max(int[] grades) {
        int max = grades[0];
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    // Calculate the standard deviation of the grades
    private static double std(int[] grades) {
        double average = average(grades);
        double sumOfSquares = 0;
        for (int grade : grades) {
            sumOfSquares += Math.pow(grade - average, 2);
        }
        return Math.sqrt(sumOfSquares / grades.length);
    }
}
