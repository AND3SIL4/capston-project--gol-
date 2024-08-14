import lib.Config;
import lib.Matrix;
import lib.Validations;

import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) { //Validate if the user passed args or not
            System.out.println("There is not arguments provided");
            return;
        }
        Map<String, String> config = Config.createConfigDictionary(args);
        boolean showArgs = Validations.showArgs(config);//Validate if the arguments are correct
        if (!config.isEmpty() && showArgs) {
            //Know the initial cell alive or dead
            String population = config.get("population");
            int n = Integer.parseInt(config.get("width"));
            int m = Integer.parseInt(config.get("height"));

            if (population != null && !population.trim().isEmpty()) {
                int[][] matrix = Matrix.createMatrix(population, n, m); //initial population
                Matrix.printMatrix(matrix);
            }
        }//Show the arguments passed
    }
}
