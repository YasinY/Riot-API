package com.yasinyazici.riot.config.json;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Map;


public abstract class JsonDataParser<T> {

    private Gson gson = new Gson();

    private String json;

    public JsonDataParser( String json) {
        this.json = json;
    }

    protected Map<String, T> transform() {
        return gson.fromJson(json, getType());
    }

    public abstract T get();

    protected abstract Type getType();
}
