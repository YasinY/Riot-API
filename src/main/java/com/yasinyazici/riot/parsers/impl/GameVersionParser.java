package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.lang.reflect.Type;

/**
 * <p>Used to parse the game versions of league of legends.</p>
 *
 * @author Yasin
 */
public class GameVersionParser extends JsonDataParser<String[]> {

    public GameVersionParser(String json) {
        super(json);
    }


    @Override
    protected Type getType() {
        return new TypeToken<String[]>(){}.getType();
    }
}
