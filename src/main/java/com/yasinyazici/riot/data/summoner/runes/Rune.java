package com.yasinyazici.riot.data.summoner.runes;

/**
 * Created by Yasin on 08.12.2016.
 */
public class Rune {

    private int runeSlotId;

    private int runeId;

    public Rune(int runeSlotId, int runeId) {
        this.runeSlotId = runeSlotId;
        this.runeId = runeId;
    }

    public int getRuneSlotId() {
        return runeSlotId;
    }

    public int getRuneId() {
        return runeId;
    }
}
