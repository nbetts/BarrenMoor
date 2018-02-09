package model;

import java.util.ArrayList;

public class Player {
    private Coordinate coordinate;
    private ArrayList<Treasure> treasureList;
    
    public Player() {
        treasureList = new ArrayList<>();
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
}
