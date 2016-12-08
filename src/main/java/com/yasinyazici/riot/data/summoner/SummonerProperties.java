package com.yasinyazici.riot.data.summoner;

/**
 * Created by Yasin on 08.12.2016.
 */
public class SummonerProperties {

    private final long id;

    private final String name;

    private final int profileIconId;

    private final int level;

    private final long revisionDate;

    public SummonerProperties(long id, String name, int profileIconId, int level, long revisionDate) {
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.level = level;
        this.revisionDate = revisionDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public int getLevel() {
        return level;
    }

    public long getRevisionDate() {
        return revisionDate;
    }
}
