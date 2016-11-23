package com.danielbporter.halite.core;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by dporter on 11/22/16.
 */
public class GameState {
    private final int turnNumber;

    private final TileState[][] tiles;

    public GameState(int turnNumber, TileState[][] tiles) {
        this.turnNumber = turnNumber;
        this.tiles = tiles;
    }

    @Override
    public int hashCode() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object o) {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }
}
