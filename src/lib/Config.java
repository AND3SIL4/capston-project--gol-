package lib;

import java.util.HashMap;
import java.util.Map;

public class Config {
    //Method to validate if the
    public static Map<String, String> createConfigDictionary(String[] args) {
        Map<String, String> config = new HashMap<>();

        for (String arg : args) {
            String[] split = arg.split("=");
            if (split.length == 2) { // Ensure there's a key and a value
                String result = Validations.fixArgument(split[0]);
                config.put(result, split[1]);
            } else {
                System.out.println("Argument format incorrect: " + arg);
            }
        }
        return config;
    }
}
