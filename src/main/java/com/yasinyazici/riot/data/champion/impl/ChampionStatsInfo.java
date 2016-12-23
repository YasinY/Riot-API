package com.yasinyazici.riot.data.champion.impl;

/**
 * Created by Yasin on 23.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStatsInfo {

    private int defense;

    private int magic;

    private int difficulty;

    private int attack;

    public ChampionStatsInfo(int defense, int magic, int difficulty, int attack) {
        this.defense = defense;
        this.magic = magic;
        this.difficulty = difficulty;
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagic() {
        return magic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getAttack() {
        return attack;
    }
}
