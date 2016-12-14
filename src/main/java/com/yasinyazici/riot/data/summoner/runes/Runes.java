package com.yasinyazici.riot.data.summoner.runes;

/**
 * Created by Yasin on 08.12.2016.
 */
public class Runes {

    private long summonerId;
    private RunePage[] pages; // 0 - 19  (20 pages)

    public Runes(long summonerId, RunePage[] pages) {
        if(summonerId == 0 || pages == null) {
            return;
        }
        this.summonerId = summonerId;
        this.pages = pages;
    }

    public RunePage getPage(int index) {
        if(index > 19 || index < 0) {
            return null;
        }
        return pages[index];
    }

    public long getSummonerId() {
        return summonerId;
    }

    public RunePage[] getPages() {
        return pages;
    }

    public int getAmountOfPages() {
        return pages.length;
    }

}
