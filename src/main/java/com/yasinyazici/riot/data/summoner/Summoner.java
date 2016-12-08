package com.yasinyazici.riot.data.summoner;

import com.yasinyazici.riot.data.summoner.runes.Runes;

/**
 * Created by Yasin on 08.12.2016.
 */
public class Summoner {

    private SummonerProperties summonerProperties;

    private Runes runes; // Get by id

    public Summoner(SummonerProperties summonerProperties, Runes runes) {
        this.summonerProperties = summonerProperties;
        this.runes = runes;
    }

    public SummonerProperties getSummonerProperties() {
        return summonerProperties;
    }

    public Runes getRunes() {
        return runes;
    }
}
