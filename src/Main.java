
import controller.GameController;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.gameBoard.setRandomTreasure(5);
        String input, response;
        
        while(controller.isPlayingGame()) {
            controller.printMap();

            input = controller.getInput();
            // TODO: input validation
            response = controller.performAction(input);
            System.out.println(response);
        }
    }

}
