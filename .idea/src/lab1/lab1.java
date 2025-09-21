package lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Лабораторна робота №1: Робота з масивами в Java (Варіант 7).
 * Виконує додавання двох матриць A і B (C5=2) з елементами типу double (C7=0)
 * та обчислює суму найбільших елементів у стовпцях з непарними номерами і найменших
 * у стовпцях з парними номерами для результуючої матриці C (C11=7).
 */
public class MatrixLab {

    /**
     * Головний метод, який є точкою входу в програму.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        // Визначення розмірів матриць
        final int rows = 3; // Кількість рядків
        final int cols = 3; // Кількість стовпців

        // Ініціалізація матриць A і B
        double[][] matrixA = new double[rows][cols];
        double[][] matrixB = new double[rows][cols];

        // Створення сканера для введення користувачем
        Scanner scanner = new Scanner(System.in);

        // Введення елементів матриці A з валідацією
        System.out.println("Будь ласка, введіть елементи матриці A (" + rows + "x" + cols + "):");
        inputMatrix(scanner, matrixA, rows, cols);

        // Введення елементів матриці B з валідацією
        System.out.println("Будь ласка, введіть елементи матриці B (" + rows + "x" + cols + "):");
        inputMatrix(scanner, matrixB, rows, cols);

        // Виведення початкових матриць
        System.out.println("Початкова матриця A:");
        printMatrix(matrixA);
        System.out.println("Початкова матриця B:");
        printMatrix(matrixB);

        // Перевірка сумісності та додавання матриць (C5=2)
        double[][] matrixC = addMatrices(matrixA, matrixB);
        System.out.println("Результуюча матриця C (A + B, C5=2):");
        printMatrix(matrixC);

        // Обчислення операції C11=7: сума максимальних у непарних стовпцях і мінімальних у парних
        double c11Result = calculateC11Operation(matrixC);
        System.out.println("Сума найбільших елементів у стовпцях з непарними номерами " +
                "та найменших елементів у стовпцях з парними номерами (C11=7): " + c11Result);

        // Закриття сканера для звільнення ресурсів
        scanner.close();
    }

    /**
     * Введення елементів матриці від користувача з валідацією.
     *
     * @param scanner Сканер для введення
     * @param matrix  Матриця для заповнення
     * @param rows    Кількість рядків
     * @param cols    Кількість стовпців
     */
    private static void inputMatrix(Scanner scanner, double[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("matrix[" + i + "][" + j + "]: ");
                        matrix[i][j] = scanner.nextDouble();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Помилка: Будь ласка, введіть коректне значення double.");
                        scanner.next(); // Очищення некоректного введення
                    }
                }
            }
        }
    }

    /**
     * Додає дві матриці та повертає результат (C = A + B).
     *
     * @param a Перша матриця
     * @param b Друга матриця
     * @return Результуюча матриця
     * @throws IllegalArgumentException якщо матриці мають різні розміри
     */
    private static double[][] addMatrices(double[][] a, double[][] b) {
        if (a == null || b == null || a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Матриці повинні мати однакові розміри для додавання.");
        }
        int rows = a.length;
        int cols = a[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    /**
     * Обчислює суму найбільших елементів у стовпцях з непарними номерами
     * та найменших елементів у стовпцях з парними номерами (C11=7).
     *
     * @param matrix Вхідна матриця
     * @return Результат обчислення
     * @throws IllegalArgumentException якщо матриця є null або порожня
     */
    private static double calculateC11Operation(double[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Матриця є null або порожня.");
        }
        int cols = matrix[0].length;
        double result = 0.0;
        for (int j = 0; j < cols; j++) {
            double[] column = new double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][j];
            }
            if (j % 2 == 0) { // Непарні номери стовпців (0, 2, ...)
                result += findMax(column);
            } else { // Парні номери стовпців (1, 3, ...)
                result += findMin(column);
            }
        }
        return result;
    }

    /**
     * Знаходить максимальний елемент у масиві.
     *
     * @param array Вхідний масив
     * @return Максимальний елемент
     */
    private static double findMax(double[] array) {
        double max = array[0];
        for (double value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Знаходить мінімальний елемент у масиві.
     *
     * @param array Вхідний масив
     * @return Мінімальний елемент
     */
    private static double findMin(double[] array) {
        double min = array[0];
        for (double value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Виводить матрицю на екран у зрозумілому форматі.
     *
     * @param matrix Матриця для виведення
     */
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}