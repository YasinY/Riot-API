package com.yasinyazici.riot.data.champion.impl;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yasin on 23.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionImageData {

    private String full;

    private String group;

    private String sprite;

    @SerializedName("h")
    private int height;

    @SerializedName("w")
    private int width;

    private int x;

    private int y;

    public ChampionImageData(String full, String group, String sprite, int height, int width, int x, int y) {
        this.full = full;
        this.group = group;
        this.sprite = sprite;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }


    public String getFull() {
        return full;
    }

    public String getGroup() {
        return group;
    }

    public String getSprite() {
        return sprite;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
