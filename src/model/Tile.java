package model;

public class Tile {
    private Treasure treasure;
    
    public Tile() {
        treasure = null;
    }
    
    public Tile(Treasure treasure) {
        this.treasure = treasure;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }
}
