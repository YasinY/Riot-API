package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.summoner.runes.Runes;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Yasin on 13.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class RunesParser extends JsonDataParser<Runes> {

    public RunesParser(String json) {
        super(json);
    }

    @Override
    public Runes get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, Runes>>(){}.getType();
    }
}
