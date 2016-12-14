package com.yasinyazici.riot.data.activegame.data;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Mastery {

    private long masteryId;

    private int rank;

    public Mastery(long masteryId, int rank) {
        this.masteryId = masteryId;
        this.rank = rank;
    }

    public long getMasteryId() {
        return masteryId;
    }

    public int getRank() {
        return rank;
    }
}
