package com.mitch.gamem.level;

import com.mitch.gamem.key.Key;

public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction valueOf(Key key) {
        if (!key.isDirectional()) {
            return null;
        }
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
        return null;
    }

}
