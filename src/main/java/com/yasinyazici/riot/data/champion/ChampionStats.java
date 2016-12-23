package com.yasinyazici.riot.data.champion;

/**
 * Created by Yasin on 18.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStats<T> {

    private int id;

    private String title;

    private String name;

    private String key;

    private T info; // TODO: MAKE GENERICS SO YOU CAN USE THIS AS PLACEHOLDER FOR (CHAMPIONIMAGE, CHAMPIONSTATSINFO etc) 

    public ChampionStats(int id, String title, String name, String key, T info) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.key = key;
        this.info = info;
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

    public T getInfo() {
        return info;
    }
}
