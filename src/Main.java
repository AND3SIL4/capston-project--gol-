import lib.ClearTerminal;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) { //Validate if the user passed args or not
            System.out.println("There is not arguments provided");
            return;
        }
        Map<String, String> config = createConfigDictionary(args); //Validate if the arguments are correct
        if (!config.isEmpty()) {
            showArgs(config);

            String population = config.get("population");
            int n = Integer.parseInt(config.get("width"));
            int m = Integer.parseInt(config.get("height"));
            if (population != null && !population.trim().isEmpty()) {
                int[][] matrix = createMatrix(population, n, m); //initial population
                printMatrix(matrix);
            }

        }
        ; //Show the arguments passed

        ClearTerminal.clear();
    }

    //
    //Method to validate if the
    //
    public static Map<String, String> createConfigDictionary(String[] args) {
        Map<String, String> config = new HashMap<>();

        for (String arg : args) {
            String[] split = arg.split("=");
            if (split.length == 2) { // Ensure there's a key and a value
                String result = fixArgument(split[0]);
                config.put(result, split[1]);
            } else {
                System.out.println("Argument format incorrect: " + arg);
            }
        }
        return config;
    }

    //
    //Method to print the args depends on validation
    //
    private static void showArgs(Map<String, String> config) {
        // Validate and show width
        validateAndShowValue("width", config.get("width"), true);
        // Validate and show height
        validateAndShowValue("height", config.get("height"), false);
        // Validate and show generations
        validateAndShowValue("generations", config.get("generations"), false);
        // Validate and show speed
        validateAndShowValue("speed", config.get("speed"), false);
        // Validate and show population
        validateAndShowValue("population", config.get("population"), false);
        // Validate and show neighborhood
        validateAndShowValue("neighborhood", config.get("neighborhood"), true);
    }

    private static void validateAndShowValue(String key, String value, boolean isInteger) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println(key + "=[no present]");
        } else {
            try {
                if (isInteger) {
                    Integer.parseInt(value);
                    System.out.println(key + "=[" + value + "]");
                } else {
                    System.out.println(key + "=[" + value + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println(key + "=[invalid]");
            }
        }
    }

    //
    //Method to know what is the variable value
    //
    public static String fixArgument(String arg) {
        return switch (arg) {
            case "w" -> "width";
            case "h" -> "height";
            case "g" -> "generations";
            case "s" -> "speed";
            case "p" -> "population";
            case "n" -> "neighborhood";
            default -> "arg not found";
        };
    }

    //
    //Method to convert to matrix
    //
    public static int[][] createMatrix(String input, int n, int m) {
        int[][] matrix = new int[n][m];
        String[] rows = input.split("#");

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '1'){
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    //
    //Show initial population
    //
    public static void printMatrix(int[][] population) {
        for (int[] row : population) {
            for (int colum : row) {
                System.out.print(colum + " ");
            }
            System.out.println();
        }
    }
}
