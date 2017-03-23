package com.yasinyazici.riot.data.currentgame.data;

import java.util.List;

/**
 * <p>Represents a participant in an actively running game</p>
 * @author Yasin
 */
public class CurrentGameParticipant {

    /**
     * Represents if the player is a bot or not
     */
    private boolean bot;

    /**
     * Represents the champion id of the champion played by the game participant
     */
    private final long championId;

    /**
     * Represents the current set masteries of the game participant
     */
    private final List<Mastery> masteries;

    /**
     * Represents the current id the game participant has set as profile
     */
    private final long profileIconId;

    /**
     * Represents the runes the game participant has set before the game has started
     */
    private final List<Rune> runes;

    /**
     * Represents the first spell the game participant has set before the game has started
     */
    private final long spell1Id;

    /**
     * Represents the second spell the game participant has set before the game has started
     */
    private final long spell2Id;

    /**
     * Represents the summoner id of the current game participant
     */
    private final long summonerId;

    /**
     * Represents the summoner name of the game participant
     */
    private final String summonerName;

    /**
     * Represents the team the game participant is in
     */
    private final long teamId;

    /**
     * Creates a new {@link CurrentGameParticipant}
     * @param bot sets if the participant is a bot
     * @param championId sets the champion id the participant is playing
     * @param masteries sets the masteries of the participant
     * @param profileIconId sets the profile icon id of the participant
     * @param runes sets the runes of the participants
     * @param spell1Id sets the first spell of the participant
     * @param spell2Id sets the second spell of the participant
     * @param summonerId sets the summoner id of the participant
     * @param summonerName sets the summoner name of the participant
     * @param teamId sets the team id of the participant
     */
    public CurrentGameParticipant(boolean bot, long championId, List<Mastery> masteries, long profileIconId, List<Rune> runes, long spell1Id, long spell2Id, long summonerId, String summonerName, long teamId) {
        this.bot = bot;
        this.championId = championId;
        this.masteries = masteries;
        this.profileIconId = profileIconId;
        this.runes = runes;
        this.spell1Id = spell1Id;
        this.spell2Id = spell2Id;
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.teamId = teamId;
    }

    /**
     * Displays the state of if the game participant is a bot
     * @return state of the game participant
     */
    public boolean isBot() {
        return bot;
    }

    /**
     * Gets the champion id the game participant is playing
     * @return the champion id
     */
    public long getChampionId() {
        return championId;
    }

    /**
     * Gets the masteries the game participant is having ingame
     * @return the masteries
     */
    public List<Mastery> getMasteries() {
        return masteries;
    }

    /**
     * Gets the profile icon id the game participant has set
     * @return the profile icon id
     */
    public long getProfileIconId() {
        return profileIconId;
    }

    /**
     * Gets the runes of the game participant which usually get set before game start
     * @return the runes
     */
    public List<Rune> getRunes() {
        return runes;
    }

    /**
     * Gets the first spell the game participant has chosen
     * @return the first spell
     */
    public long getSpell1Id() {
        return spell1Id;
    }

    /**
     * Gets the second spell the game participant has chosen
     * @return the second spell
     */
    public long getSpell2Id() {
        return spell2Id;
    }

    /**
     * Gets the summoner id the game participant has
     * @return the summoner id
     */
    public long getSummonerId() {
        return summonerId;
    }

    /**
     * Gets the summoner name of the game participant
     * @return the summoner name
     */
    public String getSummonerName() {
        return summonerName;
    }

    /**
     * Gets the team id the game participant got assigned
     * @return the team id
     */
    public long getTeamId() {
        return teamId;
    }

    /**
     * Gets the team name of the game participant as a string
     * @return the team name
     */
    public String getTeam() {
        return teamId == 100 ?  "blue" : "red";
    }



}
