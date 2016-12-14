package com.yasinyazici.riot.config.json.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.activegame.CurrentGameInfo;

import java.lang.reflect.Type;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class CurrentGameInfoParser extends JsonDataParser<CurrentGameInfo> {
    public CurrentGameInfoParser(String json) {
        super(json);
    }

    @Override
    public CurrentGameInfo get() {
        return transformNoObject();
    }

    @Override
    protected Type getType() {
        return new TypeToken<CurrentGameInfo>() {}.getType();
    }
}
