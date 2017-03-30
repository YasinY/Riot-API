package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;

import java.lang.reflect.Type;

/**
 * <p>Used to parse a single champion mastery, see {@link ChampionMastery} as reference</p>
 *
 * @author Yasin
 */
public class ChampionMasteryParser extends JsonDataParser<ChampionMastery> {
    public ChampionMasteryParser(String json) {
        super(json);
    }

    @Override
    public ChampionMastery get() {
        return parse();
    }

    @Override
    protected Type getType() {
        return new TypeToken<ChampionMastery>() {
        }.getType();
    }
}
