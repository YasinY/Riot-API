package com.yasinyazici.riot.config.json.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.runes.Runes;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Optional;

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
        Optional<Runes> runes = transformToMap().values().stream().findFirst();
        return runes.isPresent() ? runes.get() : null;
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, Runes>>(){}.getType();
    }
}
