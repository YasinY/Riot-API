package com.yasinyazici.riot.data.currentgame.data;

/**
 * <p>Represents a single mastery stone</p>
 * @author Yasin
 */
public class Mastery {

    /**
     * The id of the mastery
     */
    private long masteryId;

    /**
     * The points on the rank it got assigned
     */
    private int rank;

    /**
     * Creates a new {@link Mastery} instance
     * @param masteryId sets the mastery id
     * @param rank sets the rank
     */
    public Mastery(long masteryId, int rank) {
        this.masteryId = masteryId;
        this.rank = rank;
    }

    /**
     * Gets the mastery id
     * @return the mastery id
     */
    public long getMasteryId() {
        return masteryId;
    }

    /**
     * Gets the rank
     * @return the rank
     */
    public int getRank() {
        return rank;
    }
}
