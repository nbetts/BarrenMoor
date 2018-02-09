package model;

public class Tile {
    private final Coordinate coordinate;
    private Treasure treasure;
    
    public Tile(Coordinate coordinate) {
        this(coordinate, null);
    }
    
    public Tile(Coordinate coordinate, Treasure treasure) {
        this.coordinate = coordinate;
        this.treasure = treasure;
    }
    
    public Coordinate getCoordinate() {
        return coordinate;
    }
    
    public boolean hasTreasure() {
        return treasure != null;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }
}
