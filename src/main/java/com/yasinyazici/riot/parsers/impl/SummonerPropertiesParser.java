package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.summoner.SummonerProperties;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Yasin on 08.12.2016.
 * TODO: Support multiple summoners in a row
 */
public class SummonerPropertiesParser extends JsonDataParser<Map<String, SummonerProperties>> {

    public SummonerPropertiesParser(String json) {
        super(json);
    }

    @Override
    public Map<String, SummonerProperties> get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, SummonerProperties>>(){}.getType();
    }

    public SummonerProperties getFirstSummoner() {
        return transform().entrySet().iterator().next().getValue();
    }
}
