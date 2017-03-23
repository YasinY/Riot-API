package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStats;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsSummary;
import com.yasinyazici.riot.parsers.JsonDataParser;
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

    public ChampionStats getStatsForChampion(long championId) {
        return transform().getChampionStatsSummary().stream().filter(championStatsSummary -> championId == championStatsSummary.getId()).findAny().orElse(null).getChampionStats();
    }
}
