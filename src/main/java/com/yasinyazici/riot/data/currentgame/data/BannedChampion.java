package com.yasinyazici.riot.data.currentgame.data;

/**
 * <p>Represents the banned champion within an active game</p>
 * @author Yasin
 */
public class BannedChampion {

    /**
     * The id of the banned champion
     */
    private long championId;

    /**
     * The number of pick turn the ban was applied at
     */
    private int pickTurn;

    /**
     * The team id of the ban
     */
    private long teamId;

    /**
     * Creates a new {@link BannedChampion} instance
     * @param championId the champion id to set
     * @param pickTurn the pick turn to set
     * @param teamId the team id to set
     */
    public BannedChampion(long championId, int pickTurn, long teamId) {
        this.championId = championId;
        this.pickTurn = pickTurn;
        this.teamId = teamId;
    }

    /**
     * Gets the id of the banned champion
     * @return the id of the banned champion
     */
    public long getChampionId() {
        return championId;
    }

    /**
     * Gets the pick turn on which the champion was banned
     * @return the pick turn on which the champion was banned
     */
    public int getPickTurn() {
        return pickTurn;
    }

    /**
     * Gets the team the champion got banned from
     * @return the team the champion got banned from
     */
    public long getTeamId() {
        return teamId;
    }
}
