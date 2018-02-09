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
    
    public String performAction(String action) {
        action = action.toLowerCase().replaceAll("[^a-z]", "");
        String response = "";

        switch (action) {
            case "n":
            case "north":
                if (canMove("north")) {
                    player.moveNorth();
                } else {
                    response = "Cannot move further North";
                }
                break;
            case "s":
            case "south":
                if (canMove("south")) {
                    player.moveSouth();
                } else {
                    response = "Cannot move further South";
                }
                break;
            case "e":
            case "east":
                if (canMove("east")) {
                    player.moveEast();
                } else {
                    response = "Cannot move further East";
                }
                break;
            case "w":
            case "west":
                if (canMove("west")) {
                    player.moveWest();
                } else {
                    response = "Cannot move further West";
                }
                break;
            case "toggle compass":
                player.setIsCompassActive(!player.isCompassActive());
                
                if (player.isCompassActive()) {
                    response = "The dial reads " + getNearestTreasureDistance() + "m.";
                }
                break;
            case "look":
                break;
            case "compass":
                response = "The dial reads " + getNearestTreasureDistance() + "m.";
                break;
            case "quit":
            case "exit":
                isPlayingGame = false;
                inputScanner.close();
                response = "Goodbye.";
                break;
             default:
                 response = "Unrecognised action.";
                 break;
        }
        
        return response;
    }
    
    public boolean canMove(String action) {
        boolean canMove = true;
        
        switch (action) {
            case "north":
                if (player.getCoordinate().getX() == 0) {
                    canMove = false;
                }
                break;
            case "south":
                if (player.getCoordinate().getX() + 1 == gameBoard.getBoardWidth()) {
                    canMove = false;
                }
                break;
            case "east":
                if (player.getCoordinate().getY() + 1 == gameBoard.getBoardWidth()) {
                    canMove = false;
                }
                break;
            case "west":
                if (player.getCoordinate().getY() == 0) {
                    canMove = false;
                }
                break;
            default:
                canMove = false;
                break;
        }
        
        return canMove;
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
