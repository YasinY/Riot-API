package com.yasinyazici.riot.config.json.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.activegame.ActiveGame;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ActiveGameParser extends JsonDataParser<ActiveGame> {

    public ActiveGameParser(String json) {
        super(json);
    }

    @Override
    public ActiveGame get() {
        Set<Map.Entry<String, ActiveGame>> map = transform().entrySet();
        map.forEach(p -> System.out.println(p.getValue().getActiveGameState().getMapId()));
        return null;
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, ActiveGame>>(){}.getType();
    }
}
