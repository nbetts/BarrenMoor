import model.GameBoard;

public class Main {

    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        
        if (board.setRandomTreasure(12)) {
            board.printGameBoard();
        }
    }

}
