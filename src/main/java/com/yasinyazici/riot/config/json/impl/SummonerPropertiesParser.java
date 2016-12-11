package com.yasinyazici.riot.config.json.impl;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.SummonerProperties;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yasin on 08.12.2016.
 */
public class SummonerPropertiesParser extends JsonDataParser {

    public SummonerProperties readJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, SummonerProperties>>(){}.getType();
        Map<String, SummonerProperties> map = gson.fromJson(json, type);
        return map.entrySet().iterator().next().getValue();
    }
}
