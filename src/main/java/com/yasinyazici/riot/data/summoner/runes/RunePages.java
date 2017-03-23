package com.yasinyazici.riot.data.summoner.runes;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yasin on 08.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class RunePages {

    private long summonerId;
    @SerializedName("pages")
    private List<RunePage> runePages; // 0 - 19  (20 pages)

    public RunePages(long summonerId, RunePage ... pages) {
        if(summonerId == 0 || pages == null) {
            return;
        }
        this.summonerId = summonerId;
        this.runePages = Arrays.asList(pages);
    }

    public RunePage getPageByName(String name) {
        return runePages.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    public RunePage getPage(int index) {
        if(index > 19 || index < 0) {
            return null;
        }
        return runePages.get(index);
    }

    public long getSummonerId() {
        return summonerId;
    }

    public List<RunePage> getPages() {
        return runePages;
    }

    public int getAmountOfPages() {
        return runePages.size();
    }

}
