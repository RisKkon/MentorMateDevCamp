import java.util.Scanner;

public class Layer {

    public int rows;
    public int cols;
    public int[][] bricks;

    public Layer(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        bricks = new int[rows][cols];
    }

    public void createLayerFromInput() {

        Scanner scanner = new Scanner(System.in);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                bricks[row][col] = scanner.nextInt();

            }
        }
    }

    public int[][] getBricks() {

        return this.bricks;
    }

    public void layerToConsole() {


        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {


                if(row - 1 >= 0) {

                    if(bricks[row][col] != bricks[row - 1][col]) {

                        System.out.print("**");

                    } else if(col < cols - 1) {

                        System.out.print(" *");
                    }
                }
            }

            System.out.println();

            for (int col = 0; col < cols; col++) {

                if(col + 1 < cols) {

                    if(bricks[row][col] == bricks[row][col + 1]) {

                        System.out.print(bricks[row][col] + " ");
                    } else {

                        System.out.print(bricks[row][col] + "*");
                    }
                } else {

                    System.out.print(bricks[row][col]);
                }
            }
            System.out.println();
        }
    }
}

