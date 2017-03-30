package com.yasinyazici.riot.parsers;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;

/**
 * <p>Used as parent to parse JSON-data returned by the official REST-API of riot</p>
 * @author Yasin
 * @param <T> the Type of Object to parse
 */
public abstract class JsonDataParser<T> {

    /**
     * The gson to parse the json data automatically by class
     */
    protected Gson gson = new Gson();

    /**
     * The json returned and read from an {@link InputStream}
     */
    private String json;

    /**
     * Creates a new {@link JsonDataParser} instance
     * @param json the json to parse data from
     */
    public JsonDataParser(String json) {
        this.json = json;
    }


    /**
     * Parses a json string given as parameter, wrapping it as a class object with the type set under {@link #getType()}, returning an instance with the Type {@link T} specified
     *
     * @param jsonString the json to parse an object from
     * @return a new object with the type specified as {@link T}
     */
    protected T parse(String jsonString) {
        return gson.fromJson(jsonString, getType());
    }

    /**
     * Parses a json file, wrapping it as a class object with the type set under {@link #getType()}, returning an instance with the Type {@link T} specified
     *
     * @param jsonFile the json file to read a json string from and then parse an object from
     * @return a new object with the type specified as {@link T}
     */
    protected T parse(File jsonFile) {
        try {
            return gson.fromJson(Files.toString(jsonFile, Charsets.UTF_8), getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Parses a json string which got defined upon construction of this class
     * @return a new object with the type specified as {@link T}
     */
    protected T parse() {
        return gson.fromJson(json, getType());
    }


    /**
     * Gets the object with the type of {@link T}
     * @return a {@link T} object
     */
    public abstract T get();

    /**
     * Gets the type for the {@link Gson} parser
     * @return the {@link Type} for the gson parser
     */
    protected abstract Type getType();
}
