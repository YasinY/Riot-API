package com.yasinyazici.riot.data.masteries;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Yasin on 17.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class MasteryData {

    private int id;

    private String name;

    private List<String> description;

    private String masteryTree;

    private int ranks;

    public MasteryData(List<String> description, int id, String masteryTree, String name, int ranks) {
        this.description = description;
        this.id = id;
        this.masteryTree = masteryTree;
        this.name = name;
        this.ranks = ranks;
    }

    public List<String> getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getMasteryTree() {
        return masteryTree;
    }

    public String getName() {
        return name;
    }

    public int getRanks() {
        return ranks;
    }
}
