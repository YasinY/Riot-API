package com.yasinyazici.riot.data.activegame.state;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ActiveGameState {

    private String gameType; //The gametype

    private int gameLength; //Current Length of game

    private String gameMode; //Gamemode

    private int mapId; //The map the active game is played on

    public ActiveGameState(String gameType, int gameLength, String gameMode, int mapId) {
        this.gameType = gameType;
        this.gameLength = gameLength;
        this.gameMode = gameMode;
        this.mapId = mapId;
    }

    public String getGameType() {
        return gameType;
    }

    public int getGameLength() {
        return gameLength;
    }

    public String getGameMode() {
        return gameMode;
    }

    public int getMapId() {
        return mapId;
    }
}
