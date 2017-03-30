package com.yasinyazici.riot.data.summoner.runes;

import com.yasinyazici.riot.data.exceptions.DataException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Represents a Singe RunePage in {@link RunePages} class</p>
 * @author Yasin
 */
public class RunePage {

    /**
     * The unique rune page id
     */
    private long id;

    /**
     * The name of the rune page
     */
    private String name; // Name of the runepage

    /**
     * Flags if the rune page is the current one
     */
    private boolean current;

    /**
     * Represents a list of Runes
     */
    private List<Rune> slots;

    // Marks: RuneData slot 1 - 9

    // Seals: RuneData slot 10 - 18

    // Glyphs: RuneData slot 19 - 27

    // Quints: 28 - 30

    /**
     * Creates a new {@link RunePage} instance
     * @param id sets the unique id of the rune page
     * @param name sets the name of the rune page
     * @param current sets the state of the rune page (if used or not)
     * @param slots sets the total runes within the runepage
     */
    public RunePage(long id, String name, boolean current, Rune ... slots) {
        this.id = id;
        this.name = name;
        this.current = current;
        this.slots = Arrays.asList(slots);
    }

    /**
     * Gets the unique id of the rune page
     * @return the unique id of the rune page
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the name of the rune page
     * @return the name of the rune page
     */
    public String getName() {
        return name;
    }

    /**
     * Flags if the rune page is currently being used
     * @return flag if used or not
     */
    public boolean isCurrent() {
        return current;
    }

    /**
     * Gets a slot based on index. <!-- -->
     * Marks: slot 1-9,
     * Seals: slot 10-18,
     * Glyphs: 19 - 27,
     * Quints: 28 - 30
     * @param index the index to look a rune after
     * @return the found rune, if not found throws Exception otherwise
     * @throws DataException thrown when the data is invalid / has not been found
     */
    public Rune getSlot(int index) throws DataException {
            if(slots == null) {
               throw new DataException("No rune availables");
            }
        return slots.get(index);
    }

    /**
     * Gets a list of all runes within the rune page
     * @return a list with all runes in the specified rune page
     */
    public List<Rune> getSlots() {
        if(slots == null) {
            return Collections.emptyList();
        }
        return slots;
    }
}
