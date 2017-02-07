package com.yasinyazici.riot.parsers;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;


public abstract class JsonDataParser<T> {

    protected Gson gson = new Gson();

    private String json;

    public JsonDataParser(String json) {
        this.json = json;
    }


    protected T transform(String jsonString) {
        return gson.fromJson(jsonString, getType());
    }

    protected T transform(File jsonFile) {
        try {
            return gson.fromJson(Files.toString(jsonFile, Charsets.UTF_8), getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected T transform() {
        return gson.fromJson(json, getType());
    }


    public abstract T get();

    protected abstract Type getType();
}
