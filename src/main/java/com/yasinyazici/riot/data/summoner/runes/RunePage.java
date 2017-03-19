package com.yasinyazici.riot.data.summoner.runes;

import com.yasinyazici.riot.data.exceptions.DataException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yasin on 08.12.2016.
 */
public class RunePage {

    private long id;

    private String name; // Name of the runepage

    private boolean current;

    private List<Rune> slots;

    // Marks: RuneData slot 1 - 9

    // Seals: RuneData slot 10 - 18

    // Glyphs: RuneData slot 19 - 27

    // Quints: 28 - 30

    public RunePage(long id, String name, boolean current, Rune ... slots) {
        this.id = id;
        this.name = name;
        this.current = current;
        this.slots = Arrays.asList(slots);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCurrent() {
        return current;
    }

    public Rune getSlot(int index) throws DataException {
            if(slots == null) {
               throw new DataException("No rune availables");
            }
        return slots.get(index);
    }
    public List<Rune> getSlots() {
        if(slots == null) {
            return Collections.emptyList();
        }
        return slots;
    }
}
