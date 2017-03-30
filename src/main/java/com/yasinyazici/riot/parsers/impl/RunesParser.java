package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.summoner.runes.RunePages;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * <p>Used to parse RunePages for given {@link Summoner}'s, see {@link RunePages} as reference</p>
 *
 * @author Yasin
 */
public class RunesParser extends JsonDataParser<Map<String, RunePages>> {

    public RunesParser(String json) {
        super(json);
    }

    @Override
    public Map<String, RunePages> get() {
        return parse();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, RunePages>>() {
        }.getType();
    }
}
