package lib;

public class Game {
    //Method to get the position in matrix
    public static void game(int[][] matrix) {
        int[][] tempMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                //Checking near neighbors
                final int i = getI(matrix, col, row);

                //Apply rules
                if (matrix[row][col] == 1) {
                    boolean ruleOne = i < 2;//Less than 2 cells: will dead
                    boolean ruleTwo = i > 3;//More than 3 cells: will dead
                    if (ruleOne || ruleTwo) {
                        tempMatrix[row][col] = 0;
                    } else {
                        tempMatrix[row][col] = 1;
                    }
                } else if (matrix[row][col] == 0) {
                    boolean ruleFour = i == 3;//Exactly 3 cells: will relive
                    if (ruleFour) {
                        tempMatrix[row][col] = 1;
                    } else {
                        tempMatrix[row][col] = 0;
                    }
                }
            }
        }

        //Copy from tempMatrix to real matrix
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = tempMatrix[row][col];
            }
        }
    }

    private static int getI(int[][] matrix, int col, int row) {
        int left = (col > 0) ? matrix[row][col - 1] : 0;
        int right = (col < matrix[row].length - 1) ? matrix[row][col + 1] : 0;
        int up = (row > 0) ? matrix[row - 1][col] : 0;
        int down = (row < matrix.length - 1) ? matrix[row + 1][col] : 0;

        //Checking diagonal neighbors
        int upLeft = (row > 0 && col > 0) ? matrix[row - 1][col - 1] : 0;
        int upRight = (row > 0 && col < matrix[row].length - 1) ? matrix[row - 1][col + 1] : 0;
        int downLeft = (row < matrix.length - 1 && col > 0) ? matrix[row + 1][col - 1] : 0;
        int downRight = (row < matrix.length - 1 && col < matrix[row].length - 1) ? matrix[row + 1][col + 1] : 0;
        //Calculate neighbors
        return left + right + up + down + upLeft + upRight + downLeft + downRight;
    }
}
