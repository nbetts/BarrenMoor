package model;
import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {
    private final int height;
    private final int width;
    private Tile[][] tiles;
    
    public GameBoard() {
        this(5);
    }
    
    public GameBoard(int boardRadius) {
        this((boardRadius * 2) + 1, (boardRadius * 2) + 1);
    }
    
    public GameBoard(int height, int width) {
        this.height = height;
        this.width = width;
        tiles = new Tile[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++ ) {
                tiles[i][j] = new Tile();
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public int getTileCount() {
        return height * width;
    }
    
    public boolean setRandomTreasure(int numberOfTreasure) {
        int tileCount = getTileCount();
        
        if (numberOfTreasure >= tileCount) {
            return false;
        }
        
        ArrayList<Integer> tileNumbers = new ArrayList<>(tileCount);
        
        for (int i = 0; i < tileCount; i++) {
            // By skipping this particular tile, the player won't begin on top of treasure.
            if (i == tileCount / 2) {
                continue;
            }
            
            tileNumbers.add(i);
        }
        
        Collections.shuffle(tileNumbers);
        
        for (int i = 0; i < numberOfTreasure; i++) {
            int tileNumber = tileNumbers.get(i);
            int x = tileNumber % height;
            int y = tileNumber / height;
            
            tiles[x][y].setTreasure(Treasure.getRandomTreasure());
        }
        
        return true;
    }
    
    // TODO remove this temp method after testing
    public void printGameBoard() {
        System.out.print(" ");
        
        for (int i = 0; i < height; i++) {
            System.out.print("--");
        }
        
        System.out.println();

        for (int i = 0; i < height; i++) {
            System.out.print("|");

            for (int j = 0; j < width; j++ ) {
                Treasure treasure = tiles[i][j].getTreasure();

                if (treasure == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(treasure.getSymbol() + " ");
                }
            }
            
            System.out.println("|");
        }
        
        System.out.print(" ");
        
        for (int i = 0; i < height; i++) {
            System.out.print("--");
        }
        
        System.out.println();
    }
}
