package com.yasinyazici.riot.data.summoner.ranked.league;

/**
 * <p>Represents the state of a league entry the summoner is currently in, representing all kind of statistics. </p>
 * @author Yasin
 */
public class LeagueEntryData {

    /**
     * The league points in the divison the summoner has achieved so far
     */
    private int leaguePoints;

    /**
     * Flags if the summoner just recently entered the divsion
     */
    private boolean isFreshBlood;

    /**
     * Flags if the summoner has won 3 games or more in a row
     */
    private boolean isHotStreak;

    /**
     * Represents the divison (I, II, III, IV, V/ Master/Challenger: I, II, III)
     */
    private String division;

    /**
     * Flags if the summoner is inactive and decaying
     */
    private boolean isInactive;

    /**
     * Flags if the summoner has played 100 or more games in the division he's currently in
     */
    private boolean isVeteran;


    /**
     * Displays the losses the summoner has had in the current division
     */
    private int losses;

    /**
     * Represents the summoner or team name (if existing)
     */
    private String playerOrTeamName;

    /**
     * Represents the summoner or team id
     */
    private String playerOrTeamId;

    /**
     * Displays the total wins the summoner has had so far
     */
    private int wins;

    /**
     * Creates a new {@link LeagueEntryData} instance
     * @param leaguePoints sets the league points of summoner
     * @param isFreshBlood sets the flag if the summoner is a fresh blood or not
     * @param isHotStreak sets the flag if the summoner is on a hot streak or not
     * @param division sets the division of the summoner
     * @param isInactive sets the flag of the inactivity of the summoner
     * @param isVeteran sets the flag of if the summoner is a veteran or not
     * @param losses sets the amount of losses the summoner has had
     * @param playerOrTeamName sets the summonername or teamname
     * @param playerOrTeamId sets the summonerid or teamid
     * @param wins sets the amount of wins the summoner has had
     */
    public LeagueEntryData(int leaguePoints, boolean isFreshBlood, boolean isHotStreak, String division, boolean isInactive, boolean isVeteran, int losses, String playerOrTeamName, String playerOrTeamId, int wins) {
        this.leaguePoints = leaguePoints;
        this.isFreshBlood = isFreshBlood;
        this.isHotStreak = isHotStreak;
        this.division = division;
        this.isInactive = isInactive;
        this.isVeteran = isVeteran;
        this.losses = losses;
        this.playerOrTeamName = playerOrTeamName;
        this.playerOrTeamId = playerOrTeamId;
        this.wins = wins;
    }

    /**
     * Gets the total amount of league points the summoner has achieved so far by winning.
     * @return the league points
     */
    public int getLeaguePoints() {
        return leaguePoints;
    }

    /**
     * Gets the flag if the summoner has just joined the division
     * @return if summoner is fresh blood
     */
    public boolean isFreshBlood() {
        return isFreshBlood;
    }

    /**
     * Gets the flag of if the summoner is on a hot streak or not
     * @return flag if summoner is on a hot streak or not
     */
    public boolean isHotStreak() {
        return isHotStreak;
    }

    /**
     * Gets the division the current summoner is located in. <!-- -->
     * Possible results: If under Challenger/Master: V, IV, III, II, I. <!-- --> III, II, I otherwise
     * @return the division the summoner is currently in
     */
    public String getDivision() {
        return division;
    }

    /**
     * Gets the flag if the player is inactive and therefore decaying
     * @return flag if the player is inactive or not
     */
    public boolean isInactive() {
        return isInactive;
    }

    /**
     * Gets the flag of if the player has played atleast 100 or more games in the divison he's currently in.
     * @return flag of player being a veteran or not
     */
    public boolean isVeteran() {
        return isVeteran;
    }

    /**
     * Gets the total amount of losses the summoner has had within his tier/divison.
     * @return total amount of losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Gets the summoner or team name of the summoner as String
     * @return the summoner or team name
     */
    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    /**
     * Gets the summoner or team id
     * @return the summoner or team id
     */
    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    /**
     * Gets the amount of wins the summoner has had so far in the tier/divison he's located in
     * @return the amount of wins
     */
    public int getWins() {
        return wins;
    }
}
