import controller.GameController;
import model.GameBoard;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.gameBoard.setRandomTreasure(5);
        controller.gameBoard.printGameBoard();
        
        double[] distances = controller.detectTreasure();
        
        for (int i = 0; i < distances.length; i++) {
            System.out.format("distance=%.2f\n", distances[i]);
        }
    }

}
