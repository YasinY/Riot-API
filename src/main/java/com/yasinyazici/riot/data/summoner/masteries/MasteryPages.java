package com.yasinyazici.riot.data.summoner.masteries;

import com.google.gson.annotations.SerializedName;

import java.util.Set;

/**
 * Created by Yasin on 17.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class MasteryPages {

    private long id;

    private Set<MasteryPage> pages;

    public MasteryPages(long id, Set<MasteryPage> pages) {
        this.id = id;
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public Set<MasteryPage> getMasteryPages() {
        return pages;
    }
}
