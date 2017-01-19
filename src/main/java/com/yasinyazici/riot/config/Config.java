package com.yasinyazici.riot.config;

import java.io.File;

/**
 * Created by Yasin on 07.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Config {

    public static APIKey API_KEY = new APIKey("RGAPI-efb86cac-af5b-44cb-908b-826e53a52cd9");

    public static String PROJECT_ROOT_DIR = System.getProperty("user.dir");

    public static String RESOURCES = System.getProperty("user.dir") + "/resources/";

    public static File MASTERIES = new File(RESOURCES + "/masteries.json");

}
