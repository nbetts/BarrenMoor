package model;
import java.util.Random;
import java.util.UUID;

public enum Treasure {
    RING ("Ring", "r"),
    CHEST ("Chest", "H"),
    SWORD ("Sword", "/"),
    COIN ("Coin", "c"),
    SHACKLES ("Shackles", "x"),
    SHOE ("Shoe", "s");
    
    private final UUID id;
    private String name;
    private String symbol;
    
    private Treasure(String name, String symbol) {
        id = UUID.randomUUID();
        this.name = name;
        this.symbol = symbol;
    }
    
    public String getId() {
        return id.toString();
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
