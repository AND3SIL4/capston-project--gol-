import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Validate if the user passed args or not
        if (args.length == 0) {
            System.out.println("There is not arguments provided");
        }
        Map<String, String> config = validateArgs(args); //Validate if the arguments are correct
        if (!config.isEmpty()) showArgs(config); //Show the arguments passed
    }

    //
    //Method to validate if the
    //
    public static Map<String, String> validateArgs(String[] args){
        Map<String, String> config = new HashMap<>();

        for (String arg: args) {
            String[] split = arg.split("=");
            String result = fixArgument(split[0]);
            config.put(result, split[1]);
        }
        return config;
    }

    //
    //Method to print the args depends on validation
    //
    private static void showArgs(Map<String, String> config){
        for (Map.Entry<String, String> entry : config.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    //
    //Method to know what is the variable value
    //
    public static String fixArgument(String arg){
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
}
