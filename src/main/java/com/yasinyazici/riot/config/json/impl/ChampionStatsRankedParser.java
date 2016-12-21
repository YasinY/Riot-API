package com.yasinyazici.riot.config.json.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;

import java.lang.reflect.Type;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionStatsRankedParser extends JsonDataParser<ChampionStatsRanked> {
    public ChampionStatsRankedParser(String json) {
        super(json);
    }

    @Override
    public ChampionStatsRanked get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<ChampionStatsRanked>(){}.getType();
    }
}
