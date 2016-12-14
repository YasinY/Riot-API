package com.yasinyazici.riot.data.activegame.properties;

import com.yasinyazici.riot.data.activegame.properties.data.BannedChampion;
import com.yasinyazici.riot.data.activegame.properties.data.Participant;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ActiveGameProperties {


    private long gameId; //Unique game identifier

    private Participant[] participants; //Participants taking apart in the game

    private String platformId; //The platform id (EUW, KR, NA etc.)

    private BannedChampion[] bannedChampions; //Banned champions

    public ActiveGameProperties(long gameId, Participant[] participants, String platformId, BannedChampion[] bannedChampions) {
        this.gameId = gameId;
        this.participants = participants;
        this.platformId = platformId;
        this.bannedChampions = bannedChampions;
    }

    public long getGameId() {
        return gameId;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public BannedChampion[] getBannedChampions() {
        return bannedChampions;
    }
}
