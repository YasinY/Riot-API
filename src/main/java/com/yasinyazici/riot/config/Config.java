package com.yasinyazici.riot.config;

import com.yasinyazici.riot.data.exceptions.PropertyNotFound;

/**
 * Created by Yasin on 07.12.2016.
 */
public class Config {

    public static APIKey API_KEY = new APIKey("RGAPI-efb86cac-af5b-44cb-908b-826e53a52cd9");

    public static final String getPlatformId(String region) throws PropertyNotFound {
        switch (region) {
            case "na":
                return "NA1";
            case "euw":
                return "EUW1";
            case "eune":
                return "EUN1";
            case "jp":
                return "JP1";
            case "kr":
                return "KR";
            case "oce":
                return "OC1";
            case "br":
                return "BR1";
            case "lan":
                return "LA1";
            case "las":
                return "LA2";
            case "ru":
                return "RU";
            case "tr":
                return "TR1";
            default:
                throw new PropertyNotFound("Property not found");
        }
    }
}
