package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.parsers.JsonDataParser;
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
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<CurrentGameInfo>() {}.getType();
    }
}
