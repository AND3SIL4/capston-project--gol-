package lib;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static Map<String, String> createConfigDictionary(String[] args) {
        //Create a base config dictionary
        Map<String, String> config = new HashMap<>();
        config.put("width", null);
        config.put("height", null);
        config.put("generations", null);
        config.put("speed", null);
        config.put("population", null);
        config.put("neighborhood", "0");//Optional
        config.put("inverse", "0");

        //Validate and split the initial argument and send for validating arguments
        for (String arg : args) {
            String[] split = arg.split("=");
            if (split.length == 2) { //Ensure there's a key and a value
                String key = Validations.fixArgument(split[0]);
                String value = split[1];
                config.put(key, value);//Put the values into the config dictionary
            } else {
                System.out.println("Argument format incorrect: " + arg);
            }
        }
        return config;
    }
}
