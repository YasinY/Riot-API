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

    private int totalAssists;

    private int totalMinionKills;

    private int totalDamageDealt;

    public ChampionStats(int totalChampionKills, int totalDeathsPerSession, int totalSessionsPlayed, int totalAssists, int totalMinionKills, int totalDamageDealt) {
        this.totalChampionKills = totalChampionKills;
        this.totalDeathsPerSession = totalDeathsPerSession;
        this.totalSessionsPlayed = totalSessionsPlayed;
        this.totalAssists = totalAssists;
        this.totalMinionKills = totalMinionKills;
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getTotalChampionKills() { return totalChampionKills; }
    public int getTotalDeathsPerSession() {
        return totalDeathsPerSession;
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

    public Double getAverageKDA(){
        return Math.floor(totalChampionKills + totalAssists) / totalDeathsPerSession;
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
