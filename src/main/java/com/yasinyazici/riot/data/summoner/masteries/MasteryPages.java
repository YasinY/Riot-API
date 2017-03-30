package com.yasinyazici.riot.data.summoner.masteries;

import com.yasinyazici.riot.data.summoner.Summoner;

import java.util.Set;

/**
 * <p>Handles all mastery pages of a specified {@link Summoner}</p>
 */
public class MasteryPages {

    /**
     * The summoner id to display all mastery pages for
     */
    private long id;

    /**
     * A Set containing all Mastery Pages
     */
    private Set<MasteryPage> pages;

    /**
     * Creates a new {@link MasteryPages} instance
     * @param id the summoner id to assign the mastery pages to
     * @param pages the total mastery pages existing
     */
    public MasteryPages(long id, Set<MasteryPage> pages) {
        this.id = id;
        this.pages = pages;
    }

    /**
     * Gets the id of the summoner owning the mastery pages
     * @return the id of the summoner
     */
    public long getId() {
        return id;
    }

    /**
     * Gets all mastery pages in a {@link Set}, which got locally defined.
     * @return all mastery pages
     */
    public Set<MasteryPage> getMasteryPages() {
        return pages;
    }
}
