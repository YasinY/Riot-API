package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * <p>Used to parse multiple {@link Summoner}'s.</p>
 *
 * @author Yasin
 */
public class SummonerParser extends JsonDataParser<Map<String, Summoner>> {

    public SummonerParser(String json) {
        super(json);
    }

    @Override
    public Map<String, Summoner> get() {
        return parse();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, Summoner>>(){}.getType();
    }

    public Summoner getFirstEntry() {
        return parse().entrySet().iterator().next().getValue();
    }
    
}
