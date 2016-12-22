package com.yasinyazici.riot.parsers;

import com.google.gson.Gson;

import java.lang.reflect.Type;


public abstract class JsonDataParser<T> {

    private Gson gson = new Gson();

    private String json;

    public JsonDataParser(String json) {
        this.json = json;
    }


    protected T transform() {
        return gson.fromJson(json, getType());
    }


    public abstract T get();

    protected abstract Type getType();
}
