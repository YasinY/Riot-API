package com.yasinyazici.riot.data.currentgame;

import com.yasinyazici.riot.data.currentgame.data.BannedChampion;
import com.yasinyazici.riot.data.currentgame.data.CurrentGameParticipant;
import com.yasinyazici.riot.data.currentgame.data.Observer;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * <p>Represents the current game the summoner is currently located in</p>
 * @author Yasin
 */
public class CurrentGameInfo {


    /**
     * A list of the banned champions within the game (3x3 => Total of 6)
     */
    private final List<BannedChampion> bannedChampions;

    /**
     * The unique game id
     */
    private final long gameId;

    /**
     * The current length of the game
     */
    private long gameLength;

    /**
     * The game mode
     * @see QueueType as refence for all kind of game modes
     */
    private final String gameMode;

    /**
     * The game queue config id
     * @see QueueType as reference for corresponding game queue config ids
     */
    private final long gameQueueConfigId;

    /**
     * The time the game has started
     */
    private final long gameStartTime;

    /**
     * The type of game the summoner is currently in
     */
    private final String gameType;

    /**
     * The map of the id the summoner is located at
     */
    private final long mapId;

    /**
     * Observers sharing a key for spectator mode
     */
    private Observer observers;


    /**
     * List of all participants participating in the game (including the summoner)
     */
    private List<CurrentGameParticipant> participants;

    /**
     * Creates a new {@link CurrentGameInfo} instance
     * @param bannedChampions sets the banned champions
     * @param gameId sets the unique id the game has
     * @param gameLength sets the game length
     * @param gameMode sets the game mode
     * @param gameQueueConfigId sets the game queue config id
     * @param gameStartTime sets the start time of the game
     * @param gameType sets the type of the game
     * @param mapId sets the map id of the game
     * @param observers sets the observer properties
     * @param participants sets the participants
     */
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

    /**
     * Gets the banned champions
     * @return the banned chmapions
     */
    public List<BannedChampion> getBannedChampionList() {
        return bannedChampions;
    }

    /**
     * Gets the game id
     * @return the game id
     */
    public long getGameId() {
        return gameId;
    }

    /**
     * Gets the game length
     * @return the game length
     */
    public long getGameLength() {
        return gameLength;
    }

    /**
     * Gets the game mode
     * @return the game mode
     */
    public String getGameMode() {
        return gameMode;
    }

    /**
     * Gets the game queue config id
     * @return the game queue config id
     */
    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    /**
     * Gets the game start time
     * @return the game start time
     */
    public long getGameStartTime() {
        return gameStartTime;
    }

    /**
     * Gets the game type
     * @return the game type
     */
    public String getGameType() {
        return gameType;
    }

    /**
     * Gets the map id the game currently has set
     * @return the map id of the game
     */
    public long getMapId() {
        return mapId;
    }

    /**
     * Gets the observer of the game
     * @return the observers
     */
    public Observer getObserver() {
        return observers;
    }

    /**
     * Gets the current participants in-game
     * @return the current participants taking part of the game
     */
    public List<CurrentGameParticipant> getParticipants() {
        return participants;
    }

    /**
     * Gets the banned champions on a specific index
     * @param index the index to filter a champion from
     * @return the {@link BannedChampion} if existing
     * @throws DataException when the Data is invalid
     */
    public BannedChampion getBannedChampion(int index) throws DataException {
        if(bannedChampions.size() == 0) {
             throw new DataException("No banned champion available");
        }
        return bannedChampions.get(index);
    }
}
