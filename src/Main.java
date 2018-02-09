
import controller.GameController;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.gameBoard.setRandomTreasure(3);
        String input, response;
        
        System.out.println("\n" + 
                " ,-,---.                       ,-,-,-.               \n" + 
                "  '|___/ ,-. ,-. ,-. ,-. ,-.   `,| | |   ,-. ,-. ,-. \n" + 
                "  ,|   \\ ,-| |   |   |-' | |     | ; | . | | | | |  \n" + 
                " `-^---' `-^ '   '   `-' ' '     '   `-' `-' `-' '   \n");
        System.out.println("You awaken to find yourself in a barren moor.\n" +
                           "Try \"look\" or \"help\" for more info.");
        
        while(controller.isPlayingGame()) {
            // Uncomment this line to see the map whilst playing.
            //controller.printMap();

            input = controller.getInput();
            response = controller.performAction(input);
            System.out.println(response);
            
            if (controller.hasAllTreasureBeenFound()) {
                System.out.println("Well done! You've found all the treasure.");
            }
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
