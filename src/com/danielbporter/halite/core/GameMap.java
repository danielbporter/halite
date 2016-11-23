package com.danielbporter.halite.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dporter on 11/22/16.
 */
public class GameMap {

    private final int WIDTH;
    private final int HEIGHT;

    private final byte[][] productionMap;

    // gameStates.get(0) is the newest GameState
    private final List<GameState> gameStates;
    private int turnCount;

    public GameMap() {
        WIDTH = 30;
        HEIGHT = 30;
        productionMap = new byte[WIDTH][HEIGHT];
        gameStates = new LinkedList<>();
        turnCount = 0;
    }

    public void nextTurn(TileState[][] tileStates) {
        gameStates.add(0, new GameState(++turnCount, tileStates));
    }
}
