package com.yasinyazici.riot.data.championmastery;

/**
 * Created by Yasin on 18.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionMastery {

    private long championId;

    private int championLevel;

    private int championPoints;

    private long championPointsSinceLastLevel;

    private long championPointsUntilNextLevel;

    private boolean chestGranted;

    private long lastPlayTime;

    private long playerId;

    public ChampionMastery(long championId, int championLevel, int championPoints, long championPointsSinceLastLevel, long championPointsUntilNextLevel, boolean chestGranted, long lastPlayTime, long playerId) {
        this.championId = championId;
        this.championLevel = championLevel;
        this.championPoints = championPoints;
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
        this.chestGranted = chestGranted;
        this.lastPlayTime = lastPlayTime;
        this.playerId = playerId;
    }


    public long getChampionId() {
        return championId;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public long getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public long getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public boolean isChestGranted() {
        return chestGranted;
    }

    public long getLastPlayTime() {
        return lastPlayTime;
    }

    public long getPlayerId() {
        return playerId;
    }
}
