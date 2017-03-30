package com.yasinyazici.riot.data.summoner.runes;

/**
 * <p>Represents a single rune</p>
 * @author Yasin
 */
public class Rune {

    /**
     * The id of the slot the rune should get assigned to
     */
    private int runeSlotId;

    /**
     * The rune id itself used to identify what kind of rune is being represented
     */
    private int runeId;

    /**
     * Constructs a new {@link Rune} instance
     * @param runeSlotId sets the rune slot id
     * @param runeId sets the rune id
     */
    public Rune(int runeSlotId, int runeId) {
        this.runeSlotId = runeSlotId;
        this.runeId = runeId;
    }

    /**
     * Gets the id of the slot the rune gets assigned to
     * @return the rune slot id
     */
    public int getRuneSlotId() {
        return runeSlotId;
    }

    /**
     * Gets the id used to represent the rune
     * @return the rune id
     */
    public int getRuneId() {
        return runeId;
    }
}
