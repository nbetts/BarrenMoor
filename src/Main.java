
import controller.GameController;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.gameBoard.setRandomTreasure(5);
        String input, response;
        
        System.out.println("\n" + 
                " ,-,---.                       ,-,-,-.               \n" + 
                "  '|___/ ,-. ,-. ,-. ,-. ,-.   `,| | |   ,-. ,-. ,-. \n" + 
                "  ,|   \\ ,-| |   |   |-' | |     | ; | . | | | | |  \n" + 
                " `-^---' `-^ '   '   `-' ' '     '   `-' `-' `-' '   \n");
        System.out.println("You awaken to find yourself in a barren moor.  Try \"look\"");
        
        while(controller.isPlayingGame()) {
            controller.printMap();

            input = controller.getInput();
            response = controller.performAction(input);
            System.out.println(response);
        }
        
        System.out.println( 
                ",---.            . .           \n" + 
                "|  -'  ,-. ,-. ,-| |-. . . ,-. \n" + 
                "|  ,-' | | | | | | | | | | |-' \n" + 
                "`---|  `-' `-' `-^ ^-' `-| `-' \n" + 
                " ,-.|                   /|     \n" + 
                " `-+'                  `-'     \n");
    }

}
