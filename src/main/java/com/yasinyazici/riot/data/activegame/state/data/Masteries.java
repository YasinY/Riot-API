package com.yasinyazici.riot.data.activegame.state.data;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Masteries {

    private int rank;

    private int masteryId;


    public Masteries(int rank, int masteryId) {
        this.rank = rank;
        this.masteryId = masteryId;
    }

    public int getRank() {
        return rank;
    }

    public int getMasteryId() {
        return masteryId;
    }
}
