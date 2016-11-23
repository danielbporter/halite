package com.danielbporter.halite.core;

/**
 * Created by dporter on 11/22/16.
 */
public enum Direction {

    STILL(0),
    NORTH(1),
    EAST(2),
    SOUTH(3),
    WEST(4);

    private final int code;

    Direction(int code) {
        this.code = code;
    }

    public int asNumber() {
        return code;
    }

}
