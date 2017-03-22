package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.champion.ChampionStatsStatic;

import java.lang.reflect.Type;

/**
 * Created by Yasin on 18.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionInfoParser extends JsonDataParser<ChampionStatsStatic> {
    public ChampionInfoParser(String json) {
        super(json);
    }

    @Override
    public ChampionStatsStatic get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<ChampionStatsStatic>() {
        }.getType();
    }
}
