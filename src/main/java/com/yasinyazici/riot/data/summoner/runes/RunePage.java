package com.yasinyazici.riot.data.summoner.runes;

/**
 * Created by Yasin on 08.12.2016.
 */
public class RunePage {

    private long id;

    private String name; // Name of the runepage

    private boolean current;

    private Rune[] slots;

    // Marks: Rune slot 1 - 9

    // Seals: Rune slot 10 - 18

    // Glyphs: Rune slot 19 - 27

    // Quints: 28 - 30

    public RunePage(long id, String name, boolean current, Rune ... slots) {
        this.id = id;
        this.name = name;
        this.current = current;
        this.slots = slots;
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

    public Rune getSlot(int index) {
            if(slots == null) {
                System.out.println("Slots is null, no runes existing");
            }
        return slots[index];
    }
    public Rune[] getSlots() {
        if(slots == null) {
            return new Rune[] {}; //Empty
        }
        return slots;
    }
}
