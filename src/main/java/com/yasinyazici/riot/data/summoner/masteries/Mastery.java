package com.yasinyazici.riot.data.summoner.masteries;

/**
 * <p>Represents a mastery stone used in League of Legends. <!-- --> Used for displaying a single mastery stone a summoner has set.</p>
 * @author Yasin
 */
public class Mastery {

    /**
     * The id of the mastery
     */
    private long id;

    /**
     * The points on the rank it got assigned
     */
    private int rank;

    /**
     * Creates a new {@link Mastery} instance
     * @param id sets the mastery id
     * @param rank sets the rank
     */
    public Mastery(long id, int rank) {
        this.id = id;
        this.rank = rank;
    }

    /**
     * Gets the mastery id
     * @return the mastery id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the rank
     * @return the rank
     */
    public int getRank() {
        return rank;
    }
}
