package com.yasinyazici.riot.data.champion;

import com.google.gson.annotations.SerializedName;
import com.yasinyazici.riot.data.champion.impl.ChampionImageData;

/**
 * Created by Yasin on 24.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionImage {

    private final long id;

    private final String title;

    private final String name;

    private final String key;

    @SerializedName("image")
    private final ChampionImageData championImageData;

    public ChampionImage(long id, String title, String name, String key, ChampionImageData championImageData) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.key = key;
        this.championImageData = championImageData;
    }

    public long getId() {
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

    public ChampionImageData getChampionImageData() {
        return championImageData;
    }
}
