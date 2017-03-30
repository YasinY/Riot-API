package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.summoner.masteries.MasteryPages;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * <p>Used to parse MasteryPages for multiple summoners, see {@link MasteryPages} as reference</p>
 *
 * @author Yasin
 */
public class MasteriesParser extends JsonDataParser<Map<String, MasteryPages>> {
    public MasteriesParser(String json) {
        super(json);
    }

    @Override
    public Map<String, MasteryPages> get() {
        return parse();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, MasteryPages>>() {}.getType();
    }
}
