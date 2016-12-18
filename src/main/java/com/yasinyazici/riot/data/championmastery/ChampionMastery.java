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

    private boolean chestGranted;

    private long playerId;

    public ChampionMastery(long championId, int championLevel, int championPoints, boolean chestGranted, long playerId) {
        this.championId = championId;
        this.championLevel = championLevel;
        this.championPoints = championPoints;
        this.chestGranted = chestGranted;
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

    public boolean isChestGranted() {
        return chestGranted;
    }

    public long getPlayerId() {
        return playerId;
    }
}
