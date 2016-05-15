package com.mitch.gamem.key;

public enum Key {

    // Keys that are used in the program
    UP(true),
    LEFT(true),
    RIGHT(true),
    DOWN(true),
    Z(false),
    R(false),
    Q(false);

    // Whether the key is a direction or not
    private boolean isDirectional;

    /**
     * @param isDirectional whether the key is a direction i.e. UP DOWN LEFT RIGHT or not
     */
    Key(boolean isDirectional) {
        this.isDirectional = isDirectional;
    }

    // Getter
    public boolean isDirectional() {
        return isDirectional;
    }
}
