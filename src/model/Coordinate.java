package model;

public class Coordinate {
    private int x;
    private int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public double calculateDistance(Coordinate coordinate) {
        return Math.sqrt(Math.pow(x - coordinate.getX(), 2) +
                         Math.pow(y - coordinate.getY(), 2));
    }

    @Override
    public String toString() {
        return "Coordinate [x=" + x + ", y=" + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
