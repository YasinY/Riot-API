package com.yasinyazici.riot.data.masteries;

import java.util.List;

/**
 * <p>Represents a complete Mastery</p>
 * @author Yasin
 */
public class MasteryData {

    /**
     * The mastery id
     */
    private int id;

    /**
     * The mastery name
     */
    private String name;

    /**
     * The description of the mastery
     */
    private List<String> description;

    /**
     * The tree the mastery belongs to
     * Available values: FEROCITY, CUNNING, RESOLVE
     */
    private String masteryTree;

    /**
     * The amount of ranks it contains / can be leveled to
     */
    private int ranks;

    /**
     * Creates a new {@link MasteryData} instance
     * @param description sets the mastery description
     * @param id sets the id
     * @param masteryTree sets the tree of the mastery
     * @param name sets the name of the mastery
     * @param ranks sets the amount of ranks of the mastery
     */
    public MasteryData(List<String> description, int id, String masteryTree, String name, int ranks) {
        this.description = description;
        this.id = id;
        this.masteryTree = masteryTree;
        this.name = name;
        this.ranks = ranks;
    }

    /**
     * Gets the description of the mastery
     * @return the mastery description
     */
    public List<String> getDescription() {
        return description;
    }

    /**
     * Gets the id of the mastery
     * @return the mastery id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the mastery tree
     * @return the mastery tree
     */
    public String getMasteryTree() {
        return masteryTree;
    }

    /**
     * Gets the name of the mastery
     * @return the mastery name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the amount of ranks a mastery can have
     * @return the amount of possible ranks
     */
    public int getRanks() {
        return ranks;
    }
}
