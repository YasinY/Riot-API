package com.yasinyazici.riot.config.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Yasin on 08.12.2016.
 */
public abstract class JsonDataParser<T> {

    protected Gson gson = new Gson();

    protected String json;

    public JsonDataParser(String json) {
        this.json = json;
    }

    protected Map<String, T> transform() {
        Type type = new TypeToken<Map<String, T>>(){}.getType();
        return gson.fromJson(json, type);
    }

    public abstract T get();

}
