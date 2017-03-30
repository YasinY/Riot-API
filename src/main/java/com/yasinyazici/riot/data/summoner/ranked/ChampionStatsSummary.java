package com.yasinyazici.riot.data.summoner.ranked;

/**
 * <p>Displays a summary of the stats from a specific champion</p>
 *
 * @author Yasin
 */
public class ChampionStatsSummary {

    /**
     * The id of the champion
     */
    private int id;

    /**
     * The total stats of the champion the summoner has performed with
     */
    private ChampionStats stats;

    /**
     * Creates a new {@link ChampionStatsSummary} instance
     *
     * @param id    sets the id to assign the champion to
     * @param stats sets the statistics of the champion the summoner has performed with
     */
    public ChampionStatsSummary(int id, ChampionStats stats) {
        this.id = id;
        this.stats = stats;
    }

    /**
     * Gets the id of the champion
     *
     * @return the id of the champion
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the champion statistics
     *
     * @return the champion statistics
     */
    public ChampionStats getChampionStats() {
        return stats;
    }
}
