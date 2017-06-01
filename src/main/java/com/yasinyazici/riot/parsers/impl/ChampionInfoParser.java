package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.champion.ChampionStatsStatic;

import java.lang.reflect.Type;

/**
 * <p>Used to parse Champion Info, see {@link ChampionStatsStatic} as reference</p>
 * @author Yasin
 */
public class ChampionInfoParser extends JsonDataParser<ChampionStatsStatic> {
    public ChampionInfoParser(String json) {
        super(json);
    }


    @Override
    protected Type getType() {
        return new TypeToken<ChampionStatsStatic>() {
        }.getType();
    }
}
