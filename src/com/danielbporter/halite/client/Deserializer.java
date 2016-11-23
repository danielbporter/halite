package com.danielbporter.halite.client;

import com.danielbporter.halite.core.GameState;
import com.danielbporter.halite.core.TileState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

/**
 * Created by dporter on 11/22/16.
 */
public class Deserializer {

    private int mapWidth;
    private int mapHeight;

    public Deserializer() { }

    public Deserializer(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public void deserializeDimensions(String dimensionsString) {
        String[] widthThenHeight = dimensionsString.split(" ");
        mapWidth = Integer.parseInt(widthThenHeight[0]);
        mapHeight = Integer.parseInt(widthThenHeight[1]);
    }

    public byte[][] deserializeProductionMap(String mapString) {
        /*
         * Example from halite.io
         * Consider the following map:
         *
         * [2][3][4]
         * [1][2][3]
         * [0][1][2]
         *
         * This map would be encoded as:
         * "2 3 4 1 2 3 0 1 2"
         */
        Scanner scan = new Scanner(mapString);
        byte[][] productionValues = new byte[getMapWidth()][getMapHeight()];
        for (int row = 0; row < getMapHeight(); row++) {
            for (int col = 0; col < getMapWidth(); col++) {
                productionValues[row][col] = scan.nextByte();
            }
        }
        return productionValues;
    }

    public TileState[][] deserializeGameMap(String mapString) {
        /*
         * Example from halite.io
         * Consider the following map where O=ownerID and S=strength:
         *
         * [O=0,S=122] [O=1,S=25] [O=1,S=18]
         * [O=0, S=13] [O=0,S=45] [O=1,S=22]
         * [O=2,S=255] [O=2,S=85] [O=0, S=0]
         *
         * This map would be encoded as:
         * "1 0 2 1 2 0 1 1 2 2 1 0 122 25 18 13 45 22 255 85 0"
         */
        Scanner mapScan = new Scanner(mapString);
        final int TILE_COUNT = getMapWidth() * getMapHeight();

        byte[] ownerValues = new byte[TILE_COUNT];
        for (int i = 0; i < TILE_COUNT;) {
            int ownerTiles = mapScan.nextInt();
            byte owner = mapScan.nextByte();
            for (int j = 0; j < ownerTiles; j++) {
                ownerValues[i++] = owner;
            }
        }

        byte[] strengthValues = new byte[TILE_COUNT];
        for (int i = 0; i < TILE_COUNT; i++) {
            strengthValues[i] = mapScan.nextByte();
        }

        TileState[][] state = new TileState[getMapWidth()][getMapHeight()];
        int i = 0;
        for (int row = 0; row < getMapHeight(); row++) {
            for (int col = 0; col < getMapWidth(); col++) {
                state[row][col] = new TileState(ownerValues[i], strengthValues[i]);
                i++;
            }
        }

        return state;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }
}
