package com.yasinyazici.riot.data.activegame;

import com.yasinyazici.riot.data.activegame.data.BannedChampion;
import com.yasinyazici.riot.data.activegame.data.CurrentGameParticipant;
import com.yasinyazici.riot.data.activegame.data.Observer;

import java.util.List;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class CurrentGameInfo {

    private List<BannedChampion> bannedChampions;

    private long gameId;

    private long gameLength;

    private String gameMode;

    private long gameQueueConfigId;

    private long gameStartTime;

    private String gameType;

    private long mapId;

    private Observer observers;


    private List<CurrentGameParticipant> participants;

    public CurrentGameInfo(List<BannedChampion> bannedChampions, long gameId, long gameLength, String gameMode, long gameQueueConfigId, long gameStartTime, String gameType, long mapId, Observer observers, List<CurrentGameParticipant> participants) {
        this.bannedChampions = bannedChampions;
        this.gameId = gameId;
        this.gameLength = gameLength;
        this.gameMode = gameMode;
        this.gameQueueConfigId = gameQueueConfigId;
        this.gameStartTime = gameStartTime;
        this.gameType = gameType;
        this.mapId = mapId;
        this.observers = observers;
        this.participants = participants;
    }

    public List<BannedChampion> getBannedChampionList() {
        return bannedChampions;
    }

    public long getGameId() {
        return gameId;
    }

    public long getGameLength() {
        return gameLength;
    }

    public String getGameMode() {
        return gameMode;
    }

    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public String getGameType() {
        return gameType;
    }

    public long getMapId() {
        return mapId;
    }

    public Observer getObservers() {
        return observers;
    }

    public List<CurrentGameParticipant> getParticipants() {
        return participants;
    }

    public BannedChampion getBannedChampion(int index) {
        if(bannedChampions.size() == 0) {
            System.out.println("No banned champions available");
        }
        return bannedChampions.get(index);
    }
}
