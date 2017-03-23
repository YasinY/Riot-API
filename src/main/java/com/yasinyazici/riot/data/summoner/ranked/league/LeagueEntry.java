package com.yasinyazici.riot.data.summoner.ranked.league;

import java.util.List;

/**
 * <p>Represents the league a summoner is currently located at</p>
 *
 * @author Yasin
 */
public class LeagueEntry {

    /**
     * The queue in which the summoner got placed
     */
    private String queue;

    /**
     * The name of the league entry the summoner is located at
     */
    private String name;

    /**
     * The total entries the summoner has within the entry
     */
    private List<LeagueEntryData> entries;

    /**
     * The tier the summoner currently is in (V, IV, III, II, I) / (III, II, I)
     */
    private String tier;

    /**
     * Creates a new {@link LeagueEntry} instance
     * @param queue sets the queue of the league entry
     * @param name sets the name of the league entry
     * @param leagueEntryData sets the data of the league entry
     * @param tier sets the tier of the league entry
     */
    public LeagueEntry(String queue, String name, List<LeagueEntryData> leagueEntryData, String tier) {
        this.queue = queue;
        this.name = name;
        this.entries = leagueEntryData;
        this.tier = tier;
    }

    /**
     * Gets the queue the league entry currently hosts
     * @return the queue
     */
    public String getQueue() {
        return queue;
    }

    /**
     * Gets the name of the league entry
     * @return the league entry name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the total entries as {@link List}
     * @return the list of entries
     */
    public List<LeagueEntryData> getEntries() {
        return entries;
    }

    /**
     * Gets the tier of the league entry
     * @return tier of league entry
     */
    public String getTier() {
        return tier;
    }
}
