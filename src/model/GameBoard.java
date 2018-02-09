package model;
import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {
    private final int boardWidth;
    private Tile[][] tiles;
    
    public GameBoard() {
        this(5);
    }
    
    public GameBoard(int boardRadius) {
        boardWidth = (boardRadius * 2) - 1;
        tiles = new Tile[boardWidth][boardWidth];
        
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++) {
                tiles[i][j] = new Tile(new Coordinate(i, j));
            }
        }
    }

    public int getBoardWidth() {
        return boardWidth;
    }
    
    public int getTileCount() {
        return ((boardWidth * 2) - 1) * ((boardWidth * 2) - 1);
    }
    
    public boolean setRandomTreasure(int numberOfTreasure) {
        int tileCount = getTileCount();
        
        if (numberOfTreasure >= tileCount) {
            return false;
        }
        
        ArrayList<Integer> tileNumbers = new ArrayList<>(tileCount);
        
        for (int i = 0; i < tileCount; i++) {
            // Skip the middle tile so that the player won't begin on top of treasure.
            if (i != tileCount / 2) {
                tileNumbers.add(i);
            }
        }
        
        Collections.shuffle(tileNumbers);
        
        for (int i = 0; i < numberOfTreasure; i++) {
            int tileNumber = tileNumbers.get(i);
            
            int x = tileNumber % boardWidth;
            int y = tileNumber / boardWidth;
            
            tiles[x][y].setTreasure(Treasure.getRandomTreasure());
        }
        
        return true;
    }
    
    public Tile[] getTreasureTiles() {
        ArrayList<Tile> treasureTiles = new ArrayList<>(); 
        
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++ ) {
                if (tiles[i][j].hasTreasure()) {
                    treasureTiles.add(tiles[i][j]);
                }
            }
        }
        
        return (Tile[]) treasureTiles.toArray();
    }
    
    // TODO remove this temp method after testing
    public void printGameBoard() {
        System.out.print(" ");
        
        for (int i = 0; i < boardWidth; i++) {
            System.out.print("--");
        }
        
        System.out.println();

        for (int i = 0; i < boardWidth; i++) {
            System.out.print("|");

            for (int j = 0; j < boardWidth; j++ ) {
                Tile tile = tiles[i][j];

                if (tile.hasTreasure()) {
                    System.out.print(tile.getTreasure().getSymbol() + " ");
                } else {
                    System.out.print("  ");
                }
            }
            
            System.out.println("|");
        }
        
        System.out.print(" ");
        
        for (int i = 0; i < boardWidth; i++) {
            System.out.print("--");
        }
        
        System.out.println();
    }
}
