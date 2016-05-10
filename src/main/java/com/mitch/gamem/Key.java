package com.mitch.gamem;

public enum Key {

    UP(true),
    LEFT(true),
    RIGHT(true),
    DOWN(true),
    Z(false),
    R(false),
    Q(false);

    private boolean isDirectional;

    Key(boolean isDirectional) {
        this.isDirectional = isDirectional;
    }

    public boolean isDirectional() {
        return isDirectional;
    }
}
