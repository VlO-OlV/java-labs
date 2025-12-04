package lab1;

/**
 * A utility class for processing character matrices, including addition and computing the sum of rows minimal elements.
 * This class demonstrates basic matrix operations where characters are treated as their ASCII values for arithmetic.
 */
public class MatrixProcessor {
    /**
     * The main entry point of the application. Initializes two sample 5x5 character matrices A and B,
     * prints them, computes their sum as an integer matrix C, prints C, and then calculates and prints
     * the sum of rows minimum elements, both as an integer and as the corresponding character.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        final char[][] matrixA = {
            {'R', 'K', 'P', 'X', 'M'},
            {'A', 'T', 'G', 'L', 'E'},
            {'W', 'H', 'O', 'V', 'N'},
            {'J', 'F', 'U', 'S', 'Y'},
            {'B', 'Q', 'C', 'I', 'D'},
        };

        final char[][] matrixB = {
            {'Z', 'D', 'F', 'J', 'Q'},
            {'M', 'Y', 'I', 'C', 'T'},
            {'H', 'P', 'U', 'O', 'K'},
            {'S', 'B', 'V', 'R', 'N'},
            {'G', 'W', 'E', 'L', 'A'},
        };

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        int[][] matrixC = addMatrices(matrixA, matrixB);

        System.out.println("\nMatrix C:");
        printMatrix(matrixC);

        int minSumValue = minSum(matrixC);
        System.out.println("\nMin sum:\nInt: " + minSumValue + "\nChar: " + (char) minSumValue);
    }

    /**
     * Prints a character matrix to the console, with elements in each row separated by commas and spaces.
     * Each row is printed on a new line.
     *
     * @param matrix the character matrix to print
     */
    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + ((j < row.length - 1) ? ", " : ""));
            }
            System.out.println();
        }
    }

    /**
     * Prints an integer matrix to the console, with elements in each row separated by commas and spaces.
     * Each row is printed on a new line.
     *
     * @param matrix the integer matrix to print
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + ((j < row.length - 1) ? ", " : ""));
            }
            System.out.println();
        }
    }

    /**
     * Adds two character matrices element-wise, treating each character as its ASCII value, and returns the result
     * as an integer matrix. The matrices must have identical dimensions; otherwise, an exception is thrown.
     *
     * @param matrixA the first character matrix
     * @param matrixB the second character matrix
     * @return a new integer matrix containing the sum of corresponding elements from matrixA and matrixB
     * @throws IllegalArgumentException if the matrices do not have the same number of rows or columns
     */
    private static int[][] addMatrices(char[][] matrixA, char[][] matrixB) {
        if (matrixA.length != matrixB.length) throw new IllegalArgumentException("Matrices must have the same dimensions");

        int[][] matrixC = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            if (matrixA[i].length != matrixB[i].length) throw new IllegalArgumentException("Matrices must have the same dimensions");
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrixC;
    }

    /**
     * Computes the sum of the minimum elements in each row of the given integer matrix.
     *
     * @param matrix the integer matrix to process
     * @return the sum of the smallest element in each row
     */
    private static int minSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            int minElement = row[0];
            for (int j = 1; j < matrix[0].length; j++) {
                minElement = Math.min(row[j], minElement);
            }
            sum += minElement;
        }
        return sum;
    }
}