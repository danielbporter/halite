package com.danielbporter.halite.core;

/**
 * Created by dporter on 11/22/16.
 */
public class Move {

    private final int xPosition;
    private final int yPosition;
    private final Direction direction;

    public Move(int xPosition, int yPosition, Direction direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + xPosition;
        hash = 31 * hash + yPosition;
        hash = 31 * hash + direction.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Move)) {
            return false;
        }
        Move other = (Move) o;
        return this.xPosition == other.xPosition
                && this.yPosition == other.yPosition
                && this.direction == other.direction;
    }

    @Override
    public String toString() {
        return "Move{xPos=" + xPosition + " yPos=" + yPosition + " direction=" + direction + "}";
    }
}
