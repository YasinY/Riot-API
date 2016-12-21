package com.yasinyazici.riot.data.summoner.ranked;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStatsSummary {

    private int id;

    private ChampionStats championStatsList;

    public ChampionStatsSummary(int id, ChampionStats championStatsList) {
        this.id = id;
        this.championStatsList = championStatsList;
    }

    public int getId() {
        return id;
    }

    public ChampionStats getChampionStatsList() {
        return championStatsList;
    }
}
