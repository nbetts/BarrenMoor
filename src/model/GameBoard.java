package model;
import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {
    private final int boardWidth;
    private Tile[][] tiles;
    private final Coordinate startingPoint;
    
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
        
        startingPoint = new Coordinate(boardWidth / 2, boardWidth / 2);
    }

    public int getBoardWidth() {
        return boardWidth;
    }
    
    public int getTileCount() {
        return boardWidth * boardWidth;
    }
    
    public Coordinate getStartingPoint() {
        return startingPoint;
    }
    
    public boolean setRandomTreasure(int numberOfTreasure) {
        int tileCount = getTileCount();
        
        if (numberOfTreasure >= tileCount) {
            return false;
        }
        
        ArrayList<Integer> tileNumbers = new ArrayList<>(tileCount);
        int startingTile = (startingPoint.getX() * boardWidth) +
                            startingPoint.getY();
        
        for (int i = 0; i < tileCount; i++) {
            // Skip the middle tile so that the player won't begin on top of treasure.
            if (i != startingTile) {
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
    
    public Tile[][] getTiles() {
        return tiles;
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
        
        return treasureTiles.stream().toArray(Tile[]::new);
    }
}
