package com.yasinyazici.riot.data.summoner.ranked;

/**
 * Created by Yasin on 19.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class LeagueEntryData {

    private int leaguePoints;

    private boolean isFreshBlood;

    private boolean isHotStreak;

    private String division;

    private boolean isInactive;

    private boolean isVeteran;

    private int losses;

    private String playerOrTeamName;

    private String playerOrTeamId;

    private int wins;

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

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public boolean isFreshBlood() {
        return isFreshBlood;
    }

    public boolean isHotStreak() {
        return isHotStreak;
    }

    public String getDivision() {
        return division;
    }

    public boolean isInactive() {
        return isInactive;
    }

    public boolean isVeteran() {
        return isVeteran;
    }

    public int getLosses() {
        return losses;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    public int getWins() {
        return wins;
    }
}
