package com.yasinyazici.riot.config.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;


public abstract class JsonDataParser<T> {

    private Gson gson = new Gson();

    private String json;

    public JsonDataParser( String json) {
        this.json = json;
    }

    protected Map<String, JsonElement> transform() {
        Type type = new TypeToken<Map<String, T>>(){}.getType();
        return gson.fromJson(json, type);
    }

    public abstract T get();

}
