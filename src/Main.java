
import controller.GameController;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.gameBoard.setRandomTreasure(5);
        controller.gameBoard.printGameBoard();
    }

}
