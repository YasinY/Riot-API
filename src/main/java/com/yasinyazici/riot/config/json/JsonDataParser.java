package com.yasinyazici.riot.config.json;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


public abstract class JsonDataParser<T> {

    private Gson gson = new Gson();

    private String json;

    public JsonDataParser(String json) {
        this.json = json;
    }

    protected Map<String, T> transformToMap() {
        return gson.fromJson(json, getType());
    }

    protected T transformNoObject() {
        return gson.fromJson(json, getType());
    }

    protected List<T> transformToList() { return gson.fromJson(json, getType()); }


    public abstract T get();

    protected abstract Type getType();
}
