package com.yasinyazici.riot.data.currentgame.data;

/**
 * <p>Represents a standalone rune</p>
 * @author Yasin
 */
public class Rune {
    /**
     * The amount of runes set
     */
    private int count;

    /**
     * The rune id used to identify the rune
     */
    private int runeId;

    /**
     * Creates a new {@link Rune} instance
     * @param count sets the count of the rune
     * @param runeId sets the id of the rune
     */
    public Rune(int count, int runeId) {
        this.count = count;
        this.runeId = runeId;
    }

    /**
     * Gets the count of the rune
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Gets the id of the rune
     * @return the rune id
     */
    public int getRuneId() {
        return runeId;
    }
}
