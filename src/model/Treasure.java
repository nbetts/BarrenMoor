package model;
import java.util.Random;

public enum Treasure {
    RING ("Ring", "r"),
    CHEST ("Chest", "H"),
    SWORD ("Sword", "/"),
    COIN ("Coin", "c"),
    SHACKLES ("Shackles", "x"),
    SHOE ("Shoe", "s");
    
    private String name;
    private String symbol;
    
    private Treasure(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
    
    public static Treasure getRandomTreasure() {
        Treasure[] treasure = Treasure.values();
        Random random = new Random();
        
        return treasure[random.nextInt(treasure.length)];
    }
}
