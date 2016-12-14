package com.yasinyazici.riot.data.activegame.data;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Rune {
    private int count;

    private int runeId;

    public Rune(int count, int runeId) {
        this.count = count;
        this.runeId = runeId;
    }

    public int getCount() {
        return count;
    }

    public int getRuneId() {
        return runeId;
    }
}
