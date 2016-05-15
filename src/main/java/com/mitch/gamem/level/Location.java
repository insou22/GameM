package com.mitch.gamem.level;

public class Location {

    // x and y values for Location
    private int x;
    private int y;

    // Constructor, provide x and y values
    public Location(int x, int y) {
        // Set values to fields
        this.x = x;
        this.y = y;
    }

    // Getters and setters

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
}
