package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStats;
import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;

import java.lang.reflect.Type;

/**
 * <p>Used to parse the Champion Statistics in both ranked {@link QueueType#RANKED_FLEX_SR} and {@link QueueType#RANKED_SOLO_5x5}. <!-- -->See {@link ChampionMastery} as reference</p>
 *
 * @author Yasin
 */
public class ChampionStatsRankedParser extends JsonDataParser<ChampionStatsRanked> {
    public ChampionStatsRankedParser(String json) {
        super(json);
    }

    @Override
    protected Type getType() {
        return new TypeToken<ChampionStatsRanked>(){}.getType();
    }

    public ChampionStats getStatsForChampion(long championId) {
        return parse().getChampionStatsSummary().stream().filter(championStatsSummary -> championId == championStatsSummary.getId()).findAny().orElse(null).getChampionStats();
    }
}
