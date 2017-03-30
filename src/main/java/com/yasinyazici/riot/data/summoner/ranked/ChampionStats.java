package com.yasinyazici.riot.data.summoner.ranked;

import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;

import java.text.DecimalFormat;

/**
 * <p>Displays a statistics about a single champion the summoner has performed with in any kind of ranked game. <!-- --> See {@link QueueType} as reference</p>
 * @author Yasin
 */
public class ChampionStats {

    /**
     * Gets the total amount of champion kills the summoner
     */
    private int totalChampionKills;

    /**
     * The total amount of deaths the champion has made on average per session
     */
    private int totalDeathsPerSession;

    /**
     * The total amount of sessions played with the specific champions
     */
    private int totalSessionsPlayed;

    /**
     * The total amount of sessions lost with the specific champion
     */
    private int totalSessionsLost;

    /**
     * The total amount of total assists
     */
    private int totalAssists;

    /**
     * The total amount of minion kills
     */
    private int totalMinionKills;

    /**
     * The total damage dealt to other champions/objects
     */
    private int totalDamageDealt;

    /**
     * Constructs a new {@link ChampionStats} instance
     *
     * @param totalChampionKills    sets the total champion kills
     * @param totalDeathsPerSession sets the total deaths average per session
     * @param totalSessionsLost     sets the total sessions lost
     * @param totalSessionsPlayed   sets the total sessions played
     * @param totalAssists          sets the total assists the player has made
     * @param totalMinionKills      sets the total amount of minion kills
     * @param totalDamageDealt      sets the total damage dealt to champions/objects
     */
    public ChampionStats(int totalChampionKills, int totalDeathsPerSession, int totalSessionsLost, int totalSessionsPlayed, int totalAssists, int totalMinionKills, int totalDamageDealt) {
        this.totalChampionKills = totalChampionKills;
        this.totalDeathsPerSession = totalDeathsPerSession;
        this.totalSessionsLost = totalSessionsLost;
        this.totalSessionsPlayed = totalSessionsPlayed;
        this.totalAssists = totalAssists;
        this.totalMinionKills = totalMinionKills;
        this.totalDamageDealt = totalDamageDealt;
    }

    /**
     * Gets the total amount of champion kills
     *
     * @return the total champion kills
     */
    public int getTotalChampionKills() {
        return totalChampionKills;
    }

    /**
     * Gets the total average death/ session
     *
     * @return the total deaths per session (as average)
     */
    public int getTotalDeathsPerSession() {
        return totalDeathsPerSession;
    }

    /**
     * Gets the total amount of sessions lost with the champion
     *
     * @return total amount of sessions lost
     */
    public int getTotalSessionsLost() {
        return totalSessionsLost;
    }

    /**
     * Gets the total amounts of sessions played with the champion
     *
     * @return the total sessions played
     */
    public int getTotalSessionsPlayed() {
        return totalSessionsPlayed;
    }

    /**
     * Gets the total assists played with the champion
     *
     * @return the total assists
     */
    public int getTotalAssists() {
        return totalAssists;
    }

    /**
     * Gets the total minion kills made with the champion
     *
     * @return the total minion kills
     */
    public int getTotalMinionKills() {
        return totalMinionKills;
    }

    /**
     * Gets the total damage dealt with the champion
     *
     * @return the total damage dealt with champions
     */
    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    /**
     * Gets the win rate. <!-- -->
     * The Win rate (in %) is being calculated by using 100 as base number, subtracting the total sessions played - total sessionsLost to get the wins
     * thus dividing it by the total amount of sessions played to get the procentual value
     *
     * @return the winrate calculated
     */
    public double getWinRate() {
        return Math.floor(100.0 * (totalSessionsPlayed - totalSessionsLost) / totalSessionsPlayed);
    }

    /**
     * Gets the average KDA calculated by dividing the total amount of kills and assists by the total deaths
     * @return the average kda on all sessions
     */
    public double getAverageKDA() {
        return Math.floor(totalChampionKills + totalAssists) / (totalDeathsPerSession == 0 ? 1 : totalDeathsPerSession);
    }

    /**
     * Gets the average creep score calculated by minion kills
     * @return the average
     */
    public double getAverageCreepScore() {
        return (totalMinionKills) / totalSessionsPlayed;
    }

    /**
     * Prepares the win rate for display by formatting it, removing after comma numbers due to the pattern: " ## "
     * @return the formatted display for winrate
     */
    public String displayWinrate() {
        return new DecimalFormat("##").format(getWinRate()) + "%";
    }

    /**
     * Prepares the average kda for display by formatting it, rounding to two after comma numbers through the pattern: " ##.## "
     * @return the average KDA with the champion
     */
    public String displayAverageKDA() {
        return new DecimalFormat("##.##").format(getAverageKDA()) + ":1";
    }

    /**
     * Displays the average CS formatted with the format "##" so there are no commas.
     * @return the number of CS with the champion
     */
    public String displayAverageCreepScore() {
        return new DecimalFormat("##").format(getAverageCreepScore());
    }

}
