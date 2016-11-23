package com.danielbporter;

import java.util.ArrayList;
import java.util.List;

public class MyBot {

    private int id;

    final private int MAP_WIDTH;
    final private int MAP_HEIGHT;

    final private byte[][] productionMap;


    public MyBot(int id, GameMap initialMap) {
        this.id = id;

        MAP_WIDTH = initialMap.width;
        MAP_HEIGHT = initialMap.height;

        productionMap = new byte[MAP_WIDTH][MAP_HEIGHT];
    }

    public List<Move> doTurn(GameMap currentMap) {
        List<Site> mySites = getMySites(currentMap);
        List<Move> moves = new ArrayList<>(mySites.size());

        for (Site site : mySites) {
            moves.add(new Move(site.))
        }

        return moves;
    }

    private List<Site> getMySites(GameMap map) {
        List<Site> mySites = new ArrayList<>();
        return null;
    }

    public static void main(String[] args) throws java.io.IOException {
        InitPackage iPackage = Networking.getInit();
        int myID = iPackage.myID;

        MyBot bot = new MyBot(myID, iPackage.map);


        Networking.sendInit("MyJavaBot");

        List<Move> moves = null;
        while(true) {
//            ArrayList<Move> moves = new ArrayList<Move>();
//
//            gameMap = Networking.getFrame();
//
//            for(int y = 0; y < gameMap.height; y++) {
//                for(int x = 0; x < gameMap.width; x++) {
//                    Site site = gameMap.getSite(new Location(x, y));
//                    if(site.owner == myID) {
//                        Direction dir = Direction.randomDirection();
//                        moves.add(new Move(new Location(x, y), dir));
//                    }
//                }
//            }
            moves = bot.doTurn(Networking.getFrame());
            Networking.sendFrame(moves);
        }
    }
}
