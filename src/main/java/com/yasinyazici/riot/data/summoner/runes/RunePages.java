package com.yasinyazici.riot.data.summoner.runes;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Represents all rune pages the summoner has set</p>
 *
 * @author Yasin
 */
public class RunePages {

    /**
     * The summoner id the runepages belong to
     */
    private long summonerId;

    /**
     * The total rune pages
     */
    @SerializedName("pages")
    private List<RunePage> runePages; // 0 - 19  (20 pages)

    /**
     * Constructs a new {@link RunePages} instance
     *
     * @param summonerId sets the summoner id for the rune pages
     * @param pages      sets the total pages
     */
    public RunePages(long summonerId, RunePage... pages) {
        if (summonerId == 0 || pages == null) {
            return;
        }
        this.summonerId = summonerId;
        this.runePages = Arrays.asList(pages);
    }

    /**
     * Gets a rune page filtered by name, if none has been found returns null
     *
     * @param name name of the rune page to filter
     * @return the page found, else null if not foundf
     */
    public RunePage getPageByName(String name) {
        return runePages.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    /**
     * Gets rune page by index. <!-- -->
     * Valid throughout index 0 - 19 since it has 20 pages.
     *
     * @param index the index to look a runepage after
     * @return the page if found, else throws null
     */
    public RunePage getPage(int index) {
        if (index > 19 || index < 0) {
            return null;
        }
        return runePages.get(index);
    }

    /**
     * Gets the id of the summoner
     *
     * @return the summoner id
     */
    public long getSummonerId() {
        return summonerId;
    }

    /**
     * Gets a list with all the pages the summoner has set
     *
     * @return a list with all rune pages
     */
    public List<RunePage> getPages() {
        return runePages;
    }

    public int getAmountOfPages() {
        return runePages.size();
    }

}
