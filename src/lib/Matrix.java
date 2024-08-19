package lib;

import java.util.Random;

public class Matrix {
    //Method to convert to matrix
    public static int[][] createMatrix(String input, int rows, int cols) throws Exception {
        int[][] matrix = new int[rows][cols];//Set the matrix variable
        Random rand = new Random();//Instance the random class
        //Validate if the population is random
        if (input.equalsIgnoreCase("rnd")) {
            int aliveCells = rand.nextInt(rows * cols) + 1;
            for (int r = 0; r < aliveCells; r++) {
                int row = rand.nextInt(rows);
                int col = rand.nextInt(cols);
                matrix[row][col] = 1;
            }
        } else if (!input.contains("#")) {
            throw new IllegalArgumentException("validate this value: " + input + " and try again");
        } else {
            String[] population = input.split("#");//Get the list from initial population
            //Validate size is not bigger than matrix size
            if (population.length > rows * cols) {
                throw new Exception("Population cols is not equals to matrix size");
            }
            for (String pop : population) {
                if (pop.length() > cols) {
                    throw new Exception("Population rows is not equals to matrix size");
                }
            }
            //Put the alive cells into de matrix with the number 1
            for (int row = 0; row < population.length; row++) {
                for (int col = 0; col < population[row].length(); col++) {
                    if (population[row].charAt(col) == '1') {
                        matrix[row][col] = 1;
                    }
                }
            }
        }
        return matrix;
    }

    //Print the matrix when the method is called
    public static void printMatrix(int[][] population) {
        for (int[] row : population) {
            for (int colum : row) {
                System.out.print(colum + " ");
            }
            System.out.println();
        }
    }
}
