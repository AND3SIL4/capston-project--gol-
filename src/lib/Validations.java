package lib;

import java.util.Map;

public class Validations {
    //Method to know what is the variable value
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

    public static void validateInputs(String key, String value, boolean isInteger) throws Exception {
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
                throw new Exception(key + "=[invalid]");
            }
        }
    }

    //Method to print the args depends on validation
    public static boolean showArgs(Map<String, String> config) {
        try {
            // Validate and show width
            validateInputs("width", config.get("width"), true);
            // Validate and show height
            validateInputs("height", config.get("height"), true);
            // Validate and show generations
            validateInputs("generations", config.get("generations"), true);
            // Validate and show speed
            validateInputs("speed", config.get("speed"), true);
            // Validate and show population
            validateInputs("population", config.get("population"), false);
            // Validate and show neighborhood
            validateInputs("neighborhood", config.get("neighborhood"), true);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("An error occurred, please try again and validate the inputs");
            return false;
        }
    }
}
