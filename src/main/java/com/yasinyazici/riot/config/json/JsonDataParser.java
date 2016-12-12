package com.yasinyazici.riot.config.json;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.summoner.SummonerProperties;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class JsonDataParser<T> {

    private Gson gson = new Gson();

    private String json;

    public JsonDataParser( String json) {
        this.json = json;
    }

    protected LinkedTreeMap<String, SummonerProperties> transform() {
        Type type = new TypeToken<Map<String, SummonerProperties>>(){}.getType();
        return gson.fromJson(json, type);
    }

    public abstract T get();

}
