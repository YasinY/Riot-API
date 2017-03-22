package com.yasinyazici.riot.config;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Yasin on 07.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Config {

    public static APIKey API_KEY = new APIKey("RGAPI-01f40e72-5f98-48fd-a724-a786b4eea87e");



    public static final InputStream MASTERIES = ClassLoader.getSystemClassLoader().getResourceAsStream( "masteries.json");

    public static final InputStream RUNES = ClassLoader.getSystemClassLoader().getResourceAsStream("runes.json");

    public static final InputStream CHAMPION_DATA =  ClassLoader.getSystemClassLoader().getResourceAsStream("champion_data.json");

}
