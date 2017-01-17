package com.yasinyazici.riot.data.summoner.masteries;

import java.util.List;

/**
 * Created by Yasin on 17.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class MasteryPage {

    private boolean current;

    private long id;

    private List<Mastery> masteries;

    private String name;

    public MasteryPage(boolean current, long id, List<Mastery> masteries, String name) {
        this.current = current;
        this.id = id;
        this.masteries = masteries;
        this.name = name;
    }

    public boolean isCurrent() {
        return current;
    }

    public long getId() {
        return id;
    }

    public List<Mastery> getMasteries() {
        return masteries;
    }

    public String getName() {
        return name;
    }
}
