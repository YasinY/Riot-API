package com.yasinyazici.riot.data.summoner.runes;

/**
 * Created by Yasin on 08.12.2016.
 */
public class RunePage {

    private String name; // Name of the runepage

    private Rune[] marks; // Rune slot 1 - 9

    private Rune[] seals; // Rune slot 10 - 18

    private Rune[] glyphs; // Rune slot 19 - 27

    private Rune[] quintessences; // 28 - 30

    public RunePage(Rune[] marks, Rune[] seals, Rune[] glyphs, Rune[] quintessences) {
        this.marks = marks;
        this.seals = seals;
        this.glyphs = glyphs;
        this.quintessences = quintessences;
    }

    public String getName() {
        return name;
    }

    public Rune[] getMarks() {
        return marks;
    }

    public Rune[] getSeals() {
        return seals;
    }

    public Rune[] getGlyphs() {
        return glyphs;
    }

    public Rune[] getQuintessences() {
        return quintessences;
    }
}
