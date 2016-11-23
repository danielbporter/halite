package com.danielbporter.halite.core;

/**
 * Created by dporter on 11/22/16.
 */
public class TileState {
    private final byte ownerID;
    private final byte strength;

    public TileState(byte ownerID, byte strength) {
        this.ownerID = ownerID;
        this.strength = strength;
    }

    public byte getOwnerID() {
        return ownerID;
    }

    public byte getStrength() {
        return strength;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + (int) ownerID;
        hash = hash * 31 + (int) strength;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TileState)) {
            return false;
        }
        TileState other = (TileState) o;
        return this.ownerID == other.ownerID && this.strength == other.strength;
    }

    @Override
    public String toString() {
        return "TileState{ownerID=" + this.ownerID + " strength=" + this.strength + "}";
    }
}
