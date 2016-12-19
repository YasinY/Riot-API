package com.yasinyazici.riot.data.summoner.ranked;

import java.util.List;

/**
 * Created by Yasin on 19.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class LeagueEntry {

    private String queue;

    private String name;

    private List<LeagueEntryData> entries;

    private String tier;

    public LeagueEntry(String queue, String name, List<LeagueEntryData> leagueEntryData, String tier) {
        this.queue = queue;
        this.name = name;
        this.entries = leagueEntryData;
        this.tier = tier;
    }

    public String getQueue() {
        return queue;
    }

    public String getName() {
        return name;
    }

    public List<LeagueEntryData> getEntries() {
        return entries;
    }

    public String getTier() {
        return tier;
    }
}
