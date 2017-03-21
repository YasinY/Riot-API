package com.yasinyazici.riot.config;

import java.io.File;

/**
 * Created by Yasin on 07.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Config {

    public static APIKey API_KEY = new APIKey("RGAPI-01f40e72-5f98-48fd-a724-a786b4eea87e");

    public static final String PROJECT_ROOT_DIR = Config.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public static final String RESOURCES = PROJECT_ROOT_DIR + "/resources/";

    public static final File MASTERIES = new File(RESOURCES + "masteries.json");

    public static final File RUNES = new File(RESOURCES + "runes.json");

    public static final File CHAMPION_DATA = new File(RESOURCES + "champion_data.json");

}
