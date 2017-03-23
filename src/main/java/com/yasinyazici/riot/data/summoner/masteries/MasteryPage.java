package com.yasinyazici.riot.data.summoner.masteries;

import com.yasinyazici.riot.data.summoner.Summoner;

import java.util.List;

/**
 * <p>Represents a masterypage of a {@link Summoner}</p>
 **/
public class MasteryPage {

    /**
     * Flags if the mastery page represented is currently in use
     */
    private boolean current;

    /**
     * Represents the id of the mastery page
     */
    private long id;

    /**
     * Contains a list with masteries
     */
    private List<Mastery> masteries;

    /**
     * Represents the name of the mastery
     */
    private String name;

    /**
     * Constructs a new {@link MasteryPage} instance
     * @param current sets the current flag
     * @param id sets the id of the mastery page
     * @param masteries sets the masteries within the mastery page
     * @param name sets the mastery page name
     */
    public MasteryPage(boolean current, long id, List<Mastery> masteries, String name) {
        this.current = current;
        this.id = id;
        this.masteries = masteries;
        this.name = name;
    }

    /**
     * Flags if the mastery page is currently in use or not
     * @return current active state of mastery page
     */
    public boolean isCurrent() {
        return current;
    }

    /**
     * Gets the id of the mastery page
     * @return the mastery page id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the masteries as {@link List}
     * @return mastery list
     */
    public List<Mastery> getMasteries() {
        return masteries;
    }

    /**
     * Gets the name of the mastery page
     * @return the name of the mastery page
     */
    public String getName() {
        return name;
    }
}
