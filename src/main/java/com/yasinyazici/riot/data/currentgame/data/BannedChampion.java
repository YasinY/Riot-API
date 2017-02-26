package com.yasinyazici.riot.data.currentgame.data;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class BannedChampion {

    private long championId;

    private int pickTurn;

    private long teamId;

    public BannedChampion(long championId, int pickTurn, long teamId) {
        this.championId = championId;
        this.pickTurn = pickTurn;
        this.teamId = teamId;
    }

    public long getChampionId() {
        return championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public long getTeamId() {
        return teamId;
    }
}
