package com.yasinyazici.riot.data.runes;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Represents a whole Rune (full data set)</p>
 * @author Yasin
 */
public class RuneData {


    /**
     * Represents the full name of the rune
     */
    private String name;
    /**
     * Displays the plain text of the rune
     */
    @SerializedName("plaintext")
    private String plainText;

    /**
     * Represents the description of the rune
     */
    private String description;

    /**
     * Represents the id of the rune
     */
    private int id;

    /**
     * Represents the amount of stacks of the rune
     */
    private int stacks;

    public RuneData(String name, String plainText, String description, int id, int stacks) {
        this.name = name;
        this.plainText = plainText;
        this.description = description;
        this.id = id;
        this.stacks = stacks;
    }

    /**
     * Gets the name of the rune
     * @return the rune name
     */
    public String getName() { return name;}

    /**
     * Gets the plain text version of the rune
     * @return the plain text of the rune
     */
    public String getPlainText() {
        return plainText;
    }

    /**
     * Gets the description of the rune
     * @return the description of the rune
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the id of the rune
     * @return the rune id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the stacks of the rune
     * @return the rune stacks
     */
    public int getStacks() {
        return stacks;
    }
}
