import lib.Config;
import lib.Game;
import lib.Matrix;
import lib.Validations;

import java.util.Map;

/**
 * This class execute the main code
 * Validate if the args are empty and notify if an error occurred
 */
public class Main {
    /**
     * Execute the GOL project (game of life)
     *
     * @param args from cli in this format (w=[int] h=[int] g=[int] s=[int] p=[String] n=[int])
     */
    public static void main(String[] args) {
        if (args.length == 0) { //Validate if the user passed args or not
            System.out.println("There is not arguments provided");
            return;
        }
        //Store the config dictionary in a "config" variable
        Map<String, String> config = Config.createConfigDictionary(args);
        boolean showArgs = Validations.showArgs(config);//Validate if the arguments are correct
        if (!config.isEmpty() && showArgs) {
            //Get the initial range to display the matrix
            String population = config.get("population");

            //Validate for creating the matrix
            if (population != null && !population.trim().isEmpty()) {
                try {
                    int height = Integer.parseInt(config.get("height"));
                    int width = Integer.parseInt(config.get("width"));
                    //Validate the size of the matrix to allow execution
                    boolean validateWidth = width != 10 && width != 20 && width != 30 && width != 40 && width != 80;
                    boolean validateHeight = height != 10 && height != 20 && height != 30 && height != 40;
                    if (validateWidth || validateHeight) {
                        throw new Exception("size value invalid");
                    }

                    int[][] matrix = Matrix.createMatrix(population, height, width);//initial population
                    int g = Integer.parseInt(config.get("generations"));//Get the amount generations
                    //Display the matrix and game with the rules
                    if (g < 0) throw new Exception("generations value not valid");
                    else if (g == 0) {
                        int generations = 0;
                        int inverse = Integer.parseInt(config.get("inverse"));
                        while (true) {
                            //Execute speed
                            int s = Integer.parseInt(config.get("speed"));
                            if (generations == 0) {
                                System.out.println("Generations " + generations + 1);
                                Matrix.printMatrix(matrix);
                                generations++;
                                continue;
                            }
                            if (s >= 250 && s <= 1000) {
                                Thread.sleep(s);
                                generations++;
                            } else {
                                throw new Exception("speed invalid");
                            }

                            if (inverse == generations + 1) {
                                System.out.println("Generation " + generations + 1);
                                Game.inverse(matrix);
                                Matrix.printMatrix(matrix);
                                continue;
                            }

                            System.out.println("Generation " + (generations + 1));
                            Game.game(matrix, config);//Apply rules and update the initial matrix
                            Matrix.printMatrix(matrix);//Print matrix
                        }
                    } else {
                        for (int generations = 0; generations < g; generations++) {
                            int inverse = Integer.parseInt(config.get("inverse"));
                            //Execute speed
                            int s = Integer.parseInt(config.get("speed"));
                            if (s >= 250 && s <= 1000) {
                                Thread.sleep(s);
                            } else {
                                throw new Exception("speed invalid");
                            }
                            if (generations == 0) {
                                System.out.println("Generations " + generations + 1);
                                Matrix.printMatrix(matrix);
                                continue;
                            }
                            if (inverse == generations + 1) {
                                System.out.println("Generation " + (generations + 1));
                                Game.inverse(matrix);
                                Matrix.printMatrix(matrix);
                                continue;
                            }
                            System.out.println("Generation " + (generations + 1));
                            Game.game(matrix, config);//Apply rules and update the initial matrix
                            Matrix.printMatrix(matrix);//Print matrix
                        }
                    }
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }
    }
}
