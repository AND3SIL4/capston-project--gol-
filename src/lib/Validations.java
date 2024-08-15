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

    //Method to validate the args values and print it
    private static void validateInputs(String key, String value, boolean isInteger) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            throw new Exception(key + "=[no present]");
        } else {
            try { //Try to parse the String value in dictionary
                if (isInteger) {
                    Integer.parseInt(value);
                    System.out.print(key + "=[" + value + "] ");
                } else {
                    System.out.print(key + "=[" + value + "] ");
                }
            } catch (NumberFormatException e) {
                //Is an error happen throw an exception
                throw new Exception(key + "=[invalid]");
            }
        }
    }

    //Method to print the args depends on validation
    public static boolean showArgs(Map<String, String> config) {
        try {
            //Validate and show args
            validateInputs("width", config.get("width"), true);
            validateInputs("height", config.get("height"), true);
            validateInputs("generations", config.get("generations"), true);
            validateInputs("speed", config.get("speed"), true);
            validateInputs("population", config.get("population"), false);
            validateInputs("neighborhood", config.get("neighborhood"), true);
            System.out.println();//Make a line jump to show the matrix bellow
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("⛔ The game is not allowed to continue ⛔");
            return false;
        }
    }
}
