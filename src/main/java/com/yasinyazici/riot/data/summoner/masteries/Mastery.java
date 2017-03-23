package com.yasinyazici.riot.data.summoner.masteries;

/**
 * Created by Yasin on 17.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
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
     * Creates a new {@link com.yasinyazici.riot.data.currentgame.data.Mastery} instance
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
