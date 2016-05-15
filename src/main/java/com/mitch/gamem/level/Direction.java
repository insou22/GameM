package com.mitch.gamem.level;

import com.mitch.gamem.key.Key;

public enum Direction {

    // All the directions on a 2D plane
    UP,
    DOWN,
    LEFT,
    RIGHT;

    // Static utility method to convert Key to Direction
    public static Direction valueOf(Key key) {
        // If the key is not a direction
        if (!key.isDirectional()) {
            return null;
        }
        // Find the key, return equivalent Direction
        switch (key) {
            case UP:
                return UP;
            case DOWN:
                return DOWN;
            case LEFT:
                return LEFT;
            case RIGHT:
                return RIGHT;
        }
        // This should never be reached
        return null;
    }

}
