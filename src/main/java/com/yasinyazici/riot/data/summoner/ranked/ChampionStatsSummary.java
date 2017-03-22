package com.yasinyazici.riot.data.summoner.ranked;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStatsSummary {

    private int id;

    private ChampionStats stats;

    public ChampionStatsSummary(int id, ChampionStats stats) {
        this.id = id;
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public ChampionStats getChampionStats() {
        return stats;
    }
}
