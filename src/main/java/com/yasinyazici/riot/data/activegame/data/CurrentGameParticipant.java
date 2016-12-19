package com.yasinyazici.riot.data.activegame.data;

import java.util.List;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class CurrentGameParticipant {

    private boolean bot;

    private final long championId;

    private final List<Mastery> masteries;

    private final long profileIconId;

    private final List<Rune> runes;

    private final long spell1Id;

    private final long spell2Id;

    private final long summonerId;

    private final String summonerName;

    private final long teamId;

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

    public boolean isBot() {
        return bot;
    }

    public long getChampionId() {
        return championId;
    }

    public List<Mastery> getMasteries() {
        return masteries;
    }

    public long getProfileIconId() {
        return profileIconId;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public long getTeamId() {
        return teamId;
    }

    public String getTeam() {
        return teamId == 100 ?  "blue" : "red";
    }



}
