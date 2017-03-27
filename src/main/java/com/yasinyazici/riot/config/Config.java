package com.yasinyazici.riot.config;

import java.io.InputStream;
import java.net.URL;

/**
 * <p>Configuration for the API itself</p>
 *
 * @author Yasin
 */
public class Config {

    /**
     * The APIKey
     */
    public static APIKey API_KEY = new APIKey("RGAPI-01f40e72-5f98-48fd-a724-a786b4eea87e");


    /**
     * Location of the Masteries
     */
    public static final InputStream MASTERIES = getInputStreamFor("masteries.json");

    /**
     * Location of the Runes
     */
    public static final InputStream RUNES = getInputStreamFor("runes.json");

    /**
     * Location of the champion data
     */
    public static final InputStream CHAMPION_DATA = getInputStreamFor("champion_data.json");


    public static InputStream getInputStreamFor(String fileName) {
        return ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
    }

}
