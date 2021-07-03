package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class OperationsWithMatrices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, n1, m1;
        do {
            System.out.print("Enter the number of the rows of matrix 1>0 : ");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("Enter the number of the rows of matrix 1>0 : ");
                in.next();
            }

            n = in.nextInt();

        } while (n <= 0);
        do {
            System.out.print("Enter the number of the columns of matrix 1 >0 : ");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("Enter the number of the columns of matrix 1 >0 : ");
                in.next();
            }
            m = in.nextInt();
        } while (m <= 0);

        System.out.println();
        double[][] matrix1 = new double[n][m];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print("Enter the " + (j + 1) + " element of the " + (i + 1) + " row of the matrix1: ");
                matrix1[i][j] = in.nextInt();
            }

        }
        System.out.println();
        for (double[] i : matrix1)
            System.out.println(Arrays.toString(i));
        System.out.println();

        do {
            System.out.print("Enter the number of the rows of matrix 2>0 : ");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("Enter the number of the rows of matrix 2>0 : ");
                in.next();
            }

            n1 = in.nextInt();

        } while (n1 <= 0);
        do {
            System.out.print("Enter the number of the columns of matrix 2 >0 : ");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("Enter the number of the columns of matrix 2 >0 : ");
                in.next();
            }
            m1 = in.nextInt();
        } while (m1 <= 0);

        double[][] matrix2 = new double[n1][m1];
        System.out.println();
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print("Enter the " + (j + 1) + " element of the " + (i + 1) + " row of the matrix2: ");
                matrix2[i][j] = in.nextInt();
            }

        }
        System.out.println();
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {

                System.out.print(matrix2[i][j] + " ");

            }
            System.out.println(" ");
        }
        System.out.println("The result of subtraction of matrix1 - matrix2 is: ");
        System.out.println();
        subtractTwoMatrices(matrix1, matrix2);
        System.out.println();
        System.out.println("The result of sum of matrix1 + matrix2 is: ");
        System.out.println();
        sumOfTwoMatrix(matrix1, matrix2);
        System.out.println();
        System.out.println("The result of multiplication matrix1*matrix2 is: ");
        multiplicateMatrix(matrix1, matrix2);
        System.out.println();
        if (matrix1.length != matrix1[0].length) {
            System.out.println("The matrix must be square: invalid dimensions!");
        } else {
            double determinant = calculateMatrixDeterminant(matrix1);
            System.out.println("The determinant of matrix1 is: " + determinant);
            System.out.println();

            if (calculateMatrixDeterminant(matrix1) == 0) {
                System.out.println("The determinant of matrix1 is:0 so it doesn't inverse!");
            } else {
                System.out.println("The inverse matrix of matrix 1 is : ");

                for (double[] i : inverseMatrix(matrix1))
                    System.out.println(Arrays.toString(i));
                System.out.println();
            }
        }
        checkMatrixBecomesE(matrix1);
    }

    public static void sumOfTwoMatrix(double[][] matrix1, double[][] matrix2) {
        // sum of two matrix is possible only when both matrices have the same size
        if (matrix1[0].length != matrix2[0].length || matrix1.length != matrix2.length) {
            System.out.println("It is impossible to sum these 2 matrix!");
        } else {
            double[][] result = new double[matrix1.length][matrix2[0].length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {

                    result[i][j] = matrix1[i][j] + matrix2[i][j];

                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");

                }
                System.out.println(" ");
            }
        }
    }

    public static void subtractTwoMatrices(double[][] matrix1, double[][] matrix2) {
        // subtraction of two matrix is possible only when both matrices have the same size
        if (matrix1[0].length != matrix2[0].length || matrix1.length != matrix2.length) {
            System.out.println("It is impossible to subtract these 2 matrix!");
            return;
        } else {
            double[][] result = new double[matrix1.length][matrix2[0].length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {

                    result[i][j] = matrix1[i][j] - matrix2[i][j];

                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");

                }
                System.out.println(" ");
            }
        }
    }

    public static void multiplicateMatrix(double[][] matrix1, double[][] matrix2) {
        // multiplication of two matrix is possible only when the number of the columns from the first matrix is equal to
        // number of the rows of the second matrix
        if (matrix1[0].length != matrix2.length) {
            System.out.println("It is impossible to multiplicate these 2 matrix!");
            return;
        }

        if (matrix1[0].length == matrix2.length) {
            double[][] result = new double[matrix1.length][matrix2[0].length];

            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {

                        result[i][j] += matrix1[i][k] * matrix2[k][j];

                    }
                }
            }

            for (int i = 0; i < result.length; i++) {

                for (int j = 0; j < result[0].length; j++) {

                    System.out.print(result[i][j] + " ");

                }
                System.out.println(" ");

            }
        }
    }

    public static double[][] findsSubmatrix(double[][] matrix, int row, int column) {
        double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    newMatrix[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return newMatrix;
    }

    public static double calculateMatrixDeterminant(double[][] matrix) {
        //recursion
        double result = 0;

        if (matrix.length == 1) {
            result = matrix[0][0];
            return (result);
        }

        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (result);
        }

        for (int i = 0; i < matrix[0].length; i++) {

            result += matrix[0][i] * Math.pow(-1, i) * calculateMatrixDeterminant(findsSubmatrix(matrix, 0, i));
        }
        return (result);

    }

    public static double[][] inverseMatrix(double[][] matrix) {
        double[][] inversed = new double[matrix.length][matrix.length];
        //If determinant of the matrix equals 0 then it doesn't inverse
        if (matrix.length == 1) {
            inversed[0][0] = 1 / matrix[0][0];
        } else {
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++)
                    inversed[i][j] = Math.pow(-1, i + j)
                            * calculateMatrixDeterminant(findsSubmatrix(matrix, i, j));

            double det = 1.0 / calculateMatrixDeterminant(matrix);
            for (int i = 0; i < inversed.length; i++) {
                for (int j = 0; j <= i; j++) {
                    double temporary = inversed[i][j];
                    inversed[i][j] = inversed[j][i] * det;
                    inversed[j][i] = temporary * det;
                }
            }
        }

        return inversed;
    }

    public static void checkMatrixBecomesE(double[][] matrix) {
        if (calculateMatrixDeterminant(matrix) == 1) {
            System.out.println("This matrix can become E!");
        } else {
            System.out.println("This matrix couldn't be transformed to E!");
        }
    }
}





