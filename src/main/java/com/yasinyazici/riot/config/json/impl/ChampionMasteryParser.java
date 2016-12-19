package com.yasinyazici.riot.config.json.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;

import java.lang.reflect.Type;

/**
 * Created by Yasin on 18.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionMasteryParser extends JsonDataParser<ChampionMastery> {
    public ChampionMasteryParser(String json) {
        super(json);
    }

    @Override
    public ChampionMastery get() {
        return transformNoObject();
    }

    @Override
    protected Type getType() {
        return new TypeToken<ChampionMastery>(){}.getType();
    }
}