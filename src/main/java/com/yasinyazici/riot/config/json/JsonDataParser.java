package com.yasinyazici.riot.config.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

/**
 * Created by Yasin on 08.12.2016.
 */
public abstract class JsonDataParser<T> {

    protected Gson gson = new Gson();

    public abstract T readJson(String json);

}
