package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.summoner.masteries.MasteryPages;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Yasin on 17.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class MasteriesParser extends JsonDataParser<Map<String, MasteryPages>> {
    public MasteriesParser(String json) {
        super(json);
        System.out.println(json);
    }

    @Override
    public Map<String, MasteryPages> get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, MasteryPages>>(){}.getType();
    }
}