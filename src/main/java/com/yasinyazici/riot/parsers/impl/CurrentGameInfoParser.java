package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;

import java.lang.reflect.Type;

/**
 * <p>Used to parse a summoners active game, see {@link CurrentGameInfo} as reference</p>
 *
 * @author Yasin
 */
public class CurrentGameInfoParser extends JsonDataParser<CurrentGameInfo> {
    public CurrentGameInfoParser(String json) {
        super(json);
    }

    @Override
    public CurrentGameInfo get() {
        return parse();
    }

    @Override
    protected Type getType() {
        return new TypeToken<CurrentGameInfo>() {
        }.getType();
    }
}
