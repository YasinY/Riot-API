package com.yasinyazici.riot.data.championmastery;

/**
 * <p>Represents the mastery the summoner has achieved so far with a champion</p>
 * @author Yasin
 */
public class ChampionMastery {

    /**
     * The champion id to display the champion mastery for
     */
    private final long championId;

    /**
     * The mastery level of the champion to represent
     */
    private int championLevel;

    /**
     * The total amount of champion points the summoner has achieved so far
     */
    private int championPoints;

    /**
     * The amount of champion points achieved since the last level up
     */
    private long championPointsSinceLastLevel;

    /**
     * How many champion points left until next level can be achieved
     */
    private long championPointsUntilNextLevel;

    /**
     * Represents the state of if the chest has been granted (s- achieved or not)
     */
    private boolean chestGranted;

    /**
     * Represents the actual timestamp of the last time the champion has been played
     */
    private long lastPlayTime;

    /**
     * Represents the player id
     */
    private final long playerId;

    /**
     * Constructs a new {@link ChampionMastery}
     * @param championId sets the champion id to assign which represents the champion with the mastery
     * @param championLevel sets the mastery level of the champion to assign
     * @param championPoints sets the amount of champion mastery points to assign
     * @param championPointsSinceLastLevel sets the amount of champion mastery points since the last level up to set
     * @param championPointsUntilNextLevel sets the amount of champion mastery points
     * @param chestGranted sets the display of the state if a chest has been earned or not
     * @param lastPlayTime sets the last time played
     * @param playerId sets the id of the player
     */
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


    /**
     * <p>Gets the champion id the player has a mastery on</p>
     * @return the champion id
     */
    public long getChampionId() {
        return championId;
    }

    /**
     * <p>Gets the level of the champion</p>
     * @return the champion level
     */
    public int getChampionLevel() {
        return championLevel;
    }

    /**
     * <p>Gets the champion mastery points</p>
     * @return the mastery points
     */
    public int getChampionPoints() {
        return championPoints;
    }

    /**
     * <p>Gets the amount of champion points earned since the last level up</p>
     * @return the amount of champion points earned since last level up
     */
    public long getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    /**
     * <p>Gets the amount of champion points until the next level is achieved</p>
     * @return the amount of champion points until the next level is achieved
     */
    public long getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    /**
     * <p>Gets the state of if the player has earned a chest for the champion or not</p>
     * @return the state of rewarded with chest or not
     */
    public boolean isChestGranted() {
        return chestGranted;
    }

    /**
     * Gets the time stamp of the summoner playing the champion the last time
     * @return the last play time of the champion
     */
    public long getLastPlayTime() {
        return lastPlayTime;
    }

    /**
     * Gets the id of the player
     * @return the id of the player
     */
    public long getPlayerId() {
        return playerId;
    }
}
