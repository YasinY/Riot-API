package com.yasinyazici.riot.data.summoner.ranked;

import java.text.DecimalFormat;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStats {

    private int totalChampionKills;

    private int totalDeathsPerSession;

    private int totalSessionsPlayed;

    private int totalSessionsLost;

    private int totalAssists;

    private int totalMinionKills;

    private int totalDamageDealt;

    public ChampionStats(int totalChampionKills, int totalDeathsPerSession, int totalSessionsLost, int totalSessionsPlayed, int totalAssists, int totalMinionKills, int totalDamageDealt) {
        this.totalChampionKills = totalChampionKills;
        this.totalDeathsPerSession = totalDeathsPerSession;
        this.totalSessionsLost = totalSessionsLost;
        this.totalSessionsPlayed = totalSessionsPlayed;
        this.totalAssists = totalAssists;
        this.totalMinionKills = totalMinionKills;
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getTotalChampionKills() {
        return totalChampionKills;
    }

    public int getTotalDeathsPerSession() {
        return totalDeathsPerSession;
    }

    public int getTotalSessionsLost() {
        return totalSessionsLost;
    }

    public int getTotalSessionsPlayed() {
        return totalSessionsPlayed;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public int getTotalMinionKills() {
        return totalMinionKills;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public double getWinrate() {
        return Math.floor(100.0 * (totalSessionsPlayed - totalSessionsLost) / totalSessionsPlayed);
    }
    public Double getAverageKDA() {
        return Math.floor(totalChampionKills + totalAssists) / (totalDeathsPerSession == 0 ? 1 : totalDeathsPerSession);
    }

    public String displayAverageKDA() {
        return new DecimalFormat("##.##").format(getAverageKDA()) + ":1";
    }

    public double getAverageCreepScore() {
        return (totalMinionKills) / totalSessionsPlayed;
    }

    public String displayAverageCreepScore() {
        return new DecimalFormat("##").format(getAverageCreepScore());
    }

}
