package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.lang.reflect.Type;

/**
 * Created by Yasin on 23.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ChampionImageParser extends JsonDataParser<ChampionImage> {
    public ChampionImageParser(String json) {
        super(json);
    }

    @Override
    public ChampionImage get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<ChampionImage>(){}.getType();
    }
}
