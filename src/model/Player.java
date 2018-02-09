package model;

import java.util.ArrayList;

public class Player {
    private int coordX;
    private int coordY;
    private ArrayList<Treasure> treasureList;
    
    public Player() {
        treasureList = new ArrayList<>();
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public ArrayList<Treasure> getTreasureList() {
        return treasureList;
    }
    
    public void addTreasure(Treasure treasure) {
        treasureList.add(treasure);
    }
}
