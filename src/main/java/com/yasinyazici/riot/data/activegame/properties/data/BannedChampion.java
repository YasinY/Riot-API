package com.yasinyazici.riot.data.activegame.properties.data;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class BannedChampion {

    private int pickTurn;

    private int championId;

    private int teamId;

    public BannedChampion(int pickTurn, int championId, int teamId) {
        this.pickTurn = pickTurn;
        this.championId = championId;
        this.teamId = teamId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(int pickTurn) {
        this.pickTurn = pickTurn;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
