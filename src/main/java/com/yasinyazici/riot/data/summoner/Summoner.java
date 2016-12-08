package com.yasinyazici.riot.data.summoner;

import com.yasinyazici.riot.data.summoner.runes.Runes;

/**
 * Created by Yasin on 08.12.2016.
 */
public class Summoner {

    private SummonerProperties summonerProperties;

    private Runes runes;

    public Summoner(SummonerProperties summonerProperties) {
        this.summonerProperties = summonerProperties;
    }

}
