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
            if (population != null && !population.trim().isEmpty()) {
                int[][] matrix = convertMatrix(population); //initial population
                showInitialPopulation(new int[10][20]);
            }

        }; //Show the arguments passed

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
    public static int[][] convertMatrix(String input){
        String[] rows = input.split("#");
        int[][] matrix = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] cols = rows[i].split("");
            matrix[i] = new int[cols.length];
            for (int j = 0; j < cols.length; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(cols[j]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid number format in matrix at position (" + i + "," + j + ")");
                    matrix[i][j] = 0; //Default value or handle error as needed
                }
            }
        }
        return matrix;
    }

    //
    //Show initial population
    //
    public static void showInitialPopulation(int[][] population) {
        for (int[] row: population){
            for (int colum: row){
                System.out.print(colum + " ");
            }
            System.out.println();
        }
    }
}
