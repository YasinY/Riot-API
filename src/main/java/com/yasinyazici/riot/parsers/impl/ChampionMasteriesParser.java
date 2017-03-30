package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;

import java.lang.reflect.Type;
import java.util.List;

/**
 * <p>Used to parse all champion masteries the player has as {@link List}, see {@link ChampionMastery} as reference</p>
 *
 * @author Yasin
 */
public class ChampionMasteriesParser extends JsonDataParser<List<ChampionMastery>> {
    public ChampionMasteriesParser(String json) {
        super(json);
    }

    @Override
    public List<ChampionMastery> get() {
        return parse();
    }

    @Override
    protected Type getType() {
        return new TypeToken<List<ChampionMastery>>() {
        }.getType();
    }
}
