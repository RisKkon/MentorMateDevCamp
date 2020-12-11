
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Get the dimensions
        String[] dimensions = scanner.nextLine().split("\\s");

        //Set rows and cols
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        //Check if the dimensions are valid
        if(!areDimensionsValid(rows, cols)) {

            System.out.println("Invalid dimensions");
            return;
        }
        //Create the first layer
        Layer layer1 = new Layer(rows, cols);
        layer1.createLayerFromInput();

        //Create the second layer
        Layer layer2 = new Layer(rows, cols);

        int value = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //Check if current block is empty
                if(layer2.getBricks()[row][col] == 0) {
                    //Can we place a vertical brick
                    if(col == cols - 1 || layer1.bricks[row][col] == layer1.getBricks()[row][col + 1]) {

                        layer2.getBricks()[row][col] = value;
                        layer2.getBricks()[row + 1][col] = value;
                    } else {
                        //If no, place a horizontal one
                        layer2.getBricks()[row][col] = value;
                        layer2.getBricks()[row][col + 1] = value;
                    }

                    value++;
                }
            }
        }
        //Check if the new layout is valid
        if(!isLayoutValid(layer2)) {

            System.out.println("Can't create a valid second layer");
            System.out.println("-1");
            return;
        }
        //Print the new layout to the console
        layer2.layerToConsole();

    }

    public static boolean areDimensionsValid(int rows, int cols) {

        if(rows < 2 || rows > 100 || cols < 2 || cols > 100) {
            return false;
        }
        if(rows % 2 != 0 || cols % 2 != 0) {
            return false;
        }
        return true;
    }

    public static boolean isLayoutValid(Layer layer) {

        for (int row = 0; row < layer.rows; row++) {

            for (int col = 0; col < layer.cols; col++) {

                if(layer.bricks[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
