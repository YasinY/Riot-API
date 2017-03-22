package com.yasinyazici.riot.data.champion;

import com.google.gson.annotations.SerializedName;
import com.yasinyazici.riot.data.champion.impl.ChampionData;

/**
 * Created by Yasin on 18.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStatsStatic {

    private final int id;

    private final String title;

    private final String name;

    private final String key;

    @SerializedName("info")
    private final ChampionData championData;

    public ChampionStatsStatic(int id, String title, String name, String key, ChampionData championData) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.key = key;
        this.championData = championData;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public ChampionData getChampionData() {
        return championData;
    }
}
