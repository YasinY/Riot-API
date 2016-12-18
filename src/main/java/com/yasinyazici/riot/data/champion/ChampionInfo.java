package com.yasinyazici.riot.data.champion;

/**
 * Created by Yasin on 18.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionInfo {

    private int id;

    private String title;

    private String name;

    private String key;

    public ChampionInfo(int id, String title, String name, String key) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.key = key;
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
}
