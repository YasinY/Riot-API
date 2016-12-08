package com.yasinyazici.riot.data.summoner.runes;

/**
 * Created by Yasin on 08.12.2016.
 */
public class Runes {

    private RunePage[] runePages; // 0 - 19  (20 pages)

    public Runes(RunePage[] runePages) {
        if(runePages == null) {
            return;
        }
        this.runePages = runePages;
    }

    public RunePage getRunePage(int index) {
        if(index > 19 || index < 0) {
            return null;
        }
        return runePages[index];
    }

    public RunePage[] getRunePages() {
        return runePages;
    }

    public void setRunePages(RunePage[] runePages) {
        this.runePages = runePages;
    }
}
