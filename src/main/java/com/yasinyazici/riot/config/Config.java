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
    public static final InputStream MASTERIES = ClassLoader.getSystemClassLoader().getResourceAsStream("masteries.json");

    /**
     * Location of the Runes
     */
    public static final InputStream RUNES = ClassLoader.getSystemClassLoader().getResourceAsStream("runes.json");

    /**
     * Location of the champion data
     */
    public static final InputStream CHAMPION_DATA = ClassLoader.getSystemClassLoader().getResourceAsStream("champion_data.json");

    /**
     * Location of the version file
     */
    public static final URL VERSION_FILE = ClassLoader.getSystemClassLoader().getResource("game_version.txt");

}
