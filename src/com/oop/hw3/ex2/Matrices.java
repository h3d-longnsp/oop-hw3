package com.oop.hw3.ex2;

import java.util.Random;

public class Matrices {
    public static void main(String[] args) {
        System.out.println("--Matrix operations on int 2D arrays--");
        System.out.println("\nMatrix A:");
        int[][] matrix1 = createRandomIntMatrix(3, 3);
        printMatrix(matrix1);

        System.out.println("\nMatrix B:");
        int[][] matrix2 = createRandomIntMatrix(3, 3);
        printMatrix(matrix2);

        System.out.println("\nAdd: A + B");
        int[][] addIntMatrix = add(matrix1, matrix2);
        printMatrix(addIntMatrix);

        System.out.println("\nSubtract: A - B");
        int[][] subtractIntMatrix = subtract(matrix1, matrix2);
        printMatrix(subtractIntMatrix);

        System.out.println("\nMultiply: A x B");
        int[][] multiplyIntMatrix = multiply(matrix1, matrix2);
        printMatrix(multiplyIntMatrix);

        System.out.println("\n--Matrix operations on double 2D arrays--");
        System.out.println("\nMatrix A:");
        double[][] matrix3 = createRandomDoubleMatrix(2, 2);
        printMatrix(matrix3);

        System.out.println("\nMatrix B:");
        double[][] matrix4 = createRandomDoubleMatrix(2, 2);
        printMatrix(matrix4);

        System.out.println("\nAdd: A + B");
        double[][] addDoubleMatrix = add(matrix3, matrix4);
        printMatrix(addDoubleMatrix);

        System.out.println("\nSubtract: A - B");
        double[][] subtractDoubleMatrix = subtract(matrix3, matrix4);
        printMatrix(subtractDoubleMatrix);

        System.out.println("\nMultiply: A x B");
        double[][] multiplyDoubleMatrix = multiply(matrix3, matrix4);
        printMatrix(multiplyDoubleMatrix);
    }

    public static void fill(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Random rand = new Random();

        // Fill the matrix with random integers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(100); // Generate a random int number from 0 to 99
            }
        }
    }

    public static void fill(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Fill the matrix with random integers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Math.random() * 100; // Generate a random double number from 0 to 99
            }
        }
    }

    public static int[][] createRandomIntMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        fill(matrix);
        return matrix;
    }

    public static double[][] createRandomDoubleMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        fill(matrix);
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        int cols = matrix[0].length;

        for (int[] ints : matrix) {
            for (int j = 0; j < cols; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] matrix) {
        int cols = matrix[0].length;

        for (double[] doubles : matrix) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f ", doubles[j]);
            }
            System.out.println();
        }
    }

    // Used in add() and subtract()
    public static boolean haveSameDimension(int[][] matrix1, int[][] matrix2) {
        return matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length;
    }

    public static boolean haveSameDimension(double[][] matrix1, double[][] matrix2) {
        return matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length;
    }

    // Used in multiply()
    public static boolean isMultipliable(int[][] matrix1, int[][] matrix2) {
        return matrix1[0].length == matrix2.length;
    }

    public static boolean isMultipliable(double[][] matrix1, double[][] matrix2) {
        return matrix1[0].length == matrix2.length;
    }

    public static int[][] add(int[][] matrix1, int[][] matrix2) {
        if (haveSameDimension(matrix1, matrix2)) {
            int rows = matrix1.length;
            int cols = matrix1[0].length;
            int[][] result = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

            return result;
        } else {
            throw new IllegalArgumentException("Matrices must have the same dimensions!");
        }
    }

    public static double[][] add(double[][] matrix1, double[][] matrix2) {
        if (haveSameDimension(matrix1, matrix2)) {
            int rows = matrix1.length;
            int cols = matrix1[0].length;
            double[][] result = new double[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

            return result;
        } else {
            throw new IllegalArgumentException("Matrices must have the same dimensions!");
        }
    }

    public static int[][] subtract(int[][] matrix1, int[][] matrix2) {
        if (haveSameDimension(matrix1, matrix2)) {
            int rows = matrix1.length;
            int cols = matrix1[0].length;
            int[][] result = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }

            return result;
        } else {
            throw new IllegalArgumentException("Matrices must have the same dimensions!");
        }
    }

    public static double[][] subtract(double[][] matrix1, double[][] matrix2) {
        if (haveSameDimension(matrix1, matrix2)) {
            int rows = matrix1.length;
            int cols = matrix1[0].length;
            double[][] result = new double[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }

            return result;
        } else {
            throw new IllegalArgumentException("Matrices must have the same dimensions!");
        }
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        if (isMultipliable(matrix1, matrix2)) {
            int rows1 = matrix1.length;
            int rows2 = matrix2.length;
            int cols2 = matrix2[0].length;
            int[][] result = new int[rows1][cols2];

            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols2; j++) {
                    for (int k = 0; k < rows2; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            return result;
        } else {
            throw new IllegalArgumentException("Number of columns in matrix1 must be equal to the number of rows in matrix2 for multiplication.");
        }
    }

    public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
        if (isMultipliable(matrix1, matrix2)) {
            int rows1 = matrix1.length;
            int rows2 = matrix2.length;
            int cols2 = matrix2[0].length;
            double[][] result = new double[rows1][cols2];

            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols2; j++) {
                    for (int k = 0; k < rows2; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            return result;
        } else {
            throw new IllegalArgumentException("Number of columns in matrix1 must be equal to the number of rows in matrix2 for multiplication.");
        }
    }
}
