package com.yasinyazici.riot.data.summoner;

/**
 * Created by Yasin on 08.12.2016.
 */
public class SummonerProperties {

    private final int id;

    private final String name;

    private final int profileIconId;

    private final int summonerLevel;

    private final long revisionDate;

    public SummonerProperties(int id, String name, int profileIconId, int summonerLevel, long revisionDate) {
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public long getRevisionDate() {
        return revisionDate;
    }
}
