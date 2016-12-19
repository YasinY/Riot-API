package com.yasinyazici.riot.config.json.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.champion.ChampionInfo;

import java.lang.reflect.Type;

/**
 * Created by Yasin on 18.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionInfoParser extends JsonDataParser<ChampionInfo> {
    public ChampionInfoParser(String json) {
        super(json);
    }

    @Override
    public ChampionInfo get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<ChampionInfo>(){}.getType();
    }
}
