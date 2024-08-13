package lib;

public class Matrix {
    //Method to convert to matrix
    public static int[][] createMatrix(String input, int n, int m) {
        int[][] matrix = new int[n][m];
        String[] rows = input.split("#");

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '1') {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    //Show initial population
    public static void printMatrix(int[][] population) {
        for (int[] row : population) {
            for (int colum : row) {
                System.out.print(colum + " ");
            }
            System.out.println();
        }
    }
}
