package lab1;

public class MatrixProcessor {
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

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        int[][] matrixC = addMatrices(matrixA, matrixB);

        System.out.println("Matrix C:");
        printMatrix(matrixC);

        int minSumValue = minSum(matrixC);
        System.out.println("Min sum:\nInt: "+minSumValue+"\nChar: "+(char)minSumValue);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + ((j < row.length - 1) ? ", " : ""));
            }
            System.out.println();
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + ((j < row.length - 1) ? ", " : ""));
            }
            System.out.println();
        }
    }

    private static int[][] addMatrices(char[][] matrixA, char[][] matrixB) {
        int[][] matrixC = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrixC;
    }

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
