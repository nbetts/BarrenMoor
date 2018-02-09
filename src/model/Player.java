package model;

import java.util.ArrayList;

public class Player {
    private Coordinate coordinate;
    private ArrayList<Treasure> treasureList;
    private boolean isCompassActive;
    
    public Player() {
        this(null);
    }
    
    public Player(Coordinate coordinate) {
        this.coordinate = coordinate;
        treasureList = new ArrayList<>();
        isCompassActive = false;
    }
    
    public Coordinate getCoordinate() {
        return coordinate;
    }
    
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ArrayList<Treasure> getTreasureList() {
        return treasureList;
    }
    
    public void addTreasure(Treasure treasure) {
        treasureList.add(treasure);
    }
    
    public boolean isCompassActive() {
        return isCompassActive;
    }
    
    public void setIsCompassActive(boolean isCompassActive) {
        this.isCompassActive = isCompassActive;
    }
    
    public void moveNorth() {
        coordinate.setX(coordinate.getX() - 1);
    }
    
    public void moveSouth() {
        coordinate.setX(coordinate.getX() + 1);
    }
    
    public void moveEast() {
        coordinate.setY(coordinate.getY() + 1);
    }
    
    public void moveWest() {
        coordinate.setY(coordinate.getY() - 1);
    }
}
