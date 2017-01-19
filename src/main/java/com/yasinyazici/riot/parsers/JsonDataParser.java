package com.yasinyazici.riot.parsers;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.yasinyazici.riot.config.Config;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;


public abstract class JsonDataParser<T> {

    private Gson gson = new Gson();

    private String json;

    public JsonDataParser(String json) {
        this.json = json;
    }


    protected T transform(String jsonString) {
        return gson.fromJson(jsonString, getType());
    }
    protected T transform(File jsonFile) throws IOException {
        if(!Files.getFileExtension(jsonFile.getName()).equalsIgnoreCase("json")) {
            throw new FileNotFoundException("Not a json file!");
        }
        return gson.fromJson(Files.toString(jsonFile, Charsets.UTF_8), getType());
    }
    protected T transform() {
        return gson.fromJson(json, getType());
    }


    public abstract T get();

    protected abstract Type getType();
}
