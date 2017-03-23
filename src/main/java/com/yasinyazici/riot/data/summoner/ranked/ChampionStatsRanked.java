package com.yasinyazici.riot.data.summoner.ranked;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents the statistics of a champion the player has played in ranked (must be atleast once)
 * @author Yasin
 */
public class ChampionStatsRanked {

    /**
     * The last time the statistics have been modified
     */
    private long modifyDate;

    /**
     * Summary of the Champion Statistics
     */
    @SerializedName("champions")
    private List<ChampionStatsSummary> championStatsSummaries;

    /**
     * Represents the summoner id of the summoner
     */
    private long summonerId;

    /**
     * <p>Creates a new {@link ChampionStatsRanked} instance</p>
     * @param modifyDate the modify date the statistics have been modified at alst
     * @param championStatsSummaries the summary of all champion statistics
     * @param summonerId the representation of the summoner id
     */
    public ChampionStatsRanked(long modifyDate, List<ChampionStatsSummary> championStatsSummaries, long summonerId) {
        this.modifyDate = modifyDate;
        this.championStatsSummaries = championStatsSummaries;
        this.summonerId = summonerId;
    }

    public long getModifyDate() {
        return modifyDate;
    }


    public List<ChampionStatsSummary> getChampionStatsSummary() {
        return championStatsSummaries;
    }

    public long getSummonerId() {
        return summonerId;
    }
}
