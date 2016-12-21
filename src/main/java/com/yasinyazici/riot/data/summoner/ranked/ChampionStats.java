package com.yasinyazici.riot.data.summoner.ranked;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStats {

    private int totalDeathsPerSession;

    private int totalSessionsPlayed;

    private int totalAssists;

    private int totalMinionKills;

    private int totalDamageDealt;

    public ChampionStats(int totalDeathsPerSession, int totalSessionsPlayed, int totalAssists, int totalMinionKills, int totalDamageDealt) {
        this.totalDeathsPerSession = totalDeathsPerSession;
        this.totalSessionsPlayed = totalSessionsPlayed;
        this.totalAssists = totalAssists;
        this.totalMinionKills = totalMinionKills;
        this.totalDamageDealt = totalDamageDealt;
    }

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
}
