package controller;

import java.util.Scanner;

import model.Coordinate;
import model.GameBoard;
import model.Player;
import model.Tile;

public class GameController {
    public GameBoard gameBoard;
    public Player player;
    private boolean isPlayingGame;
    private Scanner inputScanner;
    
    public GameController() {
        this(new GameBoard());
    }
    
    public GameController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        player = new Player(gameBoard.getStartingPoint());
        isPlayingGame = true;
        inputScanner = new Scanner(System.in);
    }
    
    public boolean isPlayingGame() {
        return isPlayingGame;
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
    
    public String getInput() {
        System.out.print("> ");
        return inputScanner.nextLine();
    }
    
    public void performAction(String action) {
        action = action.toLowerCase();

        switch (action) {
            case "north":
                player.moveNorth();
                break;
            case "south":
                player.moveSouth();
                break;
            case "east":
                player.moveEast();
                break;
            case "west":
                player.moveWest();
                break;
            case "toggle compass":
                player.setIsCompassActive(!player.isCompassActive());
                break;
            case "look":
                break;
            case "quit":
            case "exit":
                isPlayingGame = false;
                inputScanner.close();
                break;
        }
    }
    
    public void printMap() {
        int boardWidth = gameBoard.getBoardWidth();
        Tile[][] tiles = gameBoard.getTiles();
        int playerX = player.getCoordinate().getX();
        int playerY = player.getCoordinate().getY();

        System.out.print(" ");
        
        for (int i = 0; i < boardWidth; i++) {
            System.out.print("--");
        }
        
        System.out.println();

        for (int i = 0; i < boardWidth; i++) {
            System.out.print("|");

            for (int j = 0; j < boardWidth; j++ ) {
                if (i == playerX && j == playerY) {
                    System.out.print("+ ");
                } else {
                    Tile tile = tiles[i][j];
    
                    if (tile.hasTreasure()) {
                        System.out.print(tile.getTreasure().getSymbol() + " ");
                    } else {
                        System.out.print("  ");
                    }
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
