package com.yasinyazici.riot.config.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

/**
 * Created by Yasin on 08.12.2016.
 */
public abstract class JsonDataParser {

    protected Gson gson = new Gson();

    public abstract void readJson(String json);

}
