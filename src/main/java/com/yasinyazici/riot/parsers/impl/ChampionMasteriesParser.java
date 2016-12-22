package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionMasteriesParser extends JsonDataParser<List<ChampionMastery>> {
    public ChampionMasteriesParser(String json) {
        super(json);
    }

    @Override
    public List<ChampionMastery> get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<List<ChampionMastery>>(){}.getType();
    }
}
