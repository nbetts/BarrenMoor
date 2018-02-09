package controller;

import model.Coordinate;
import model.GameBoard;
import model.Player;
import model.Tile;

public class GameController {
    public GameBoard gameBoard;
    public Player player;
    
    public GameController() {
        this(new GameBoard());
    }
    
    public GameController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        player = new Player(gameBoard.getStartingPoint());
    }
    
    public double[] getTreasureDistances() {
        Tile[] treasureTiles = gameBoard.getTreasureTiles();
        double[] treasureDistances = new double[treasureTiles.length];
        Coordinate playerCoordinate = player.getCoordinate();
        
        for (int i = 0; i < treasureTiles.length; i++) {
            Coordinate coordinate = treasureTiles[i].getCoordinate();
            treasureDistances[i] = playerCoordinate.calculateDistance(coordinate);
        }
        
        return treasureDistances;
    }
    
    public double getNearestTreasureDistance() {
        double[] treasureDistances = getTreasureDistances();
        double nearestDistance = Double.MAX_VALUE;
        
        for (int i = 0; i < treasureDistances.length; i++) {
            if (treasureDistances[i] < nearestDistance) {
                nearestDistance = treasureDistances[i];
            }
        }
        
        return nearestDistance;
    }
}
