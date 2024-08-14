package lib;

public class Matrix {
    //Method to convert to matrix
    public static int[][] createMatrix(String input, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        String[] population = input.split("#");

        for (int row = 0; row < population.length; row++) {
            for (int col = 0; col < population[row].length(); col++) {
                if (population[row].charAt(col) == '1') {
                    matrix[row][col] = 1;
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
