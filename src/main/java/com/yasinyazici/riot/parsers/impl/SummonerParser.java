package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Yasin on 08.12.2016.
 * TODO: Support multiple summoners in a row
 */
public class SummonerParser extends JsonDataParser<Map<String, Summoner>> {

    public SummonerParser(String json) {
        super(json);
    }

    @Override
    public Map<String, Summoner> get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, Summoner>>(){}.getType();
    }

    public Summoner getFirstEntry() {
        return transform().entrySet().iterator().next().getValue();
    }
}
