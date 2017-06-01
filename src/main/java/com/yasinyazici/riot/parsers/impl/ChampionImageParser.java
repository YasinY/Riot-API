package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.lang.reflect.Type;

/**
 * <p>Used to parse Champion Images, see {@link ChampionImage} as reference</p>
 *
 * @author Yasin
 */
public class ChampionImageParser extends JsonDataParser<ChampionImage> {
    public ChampionImageParser(String json) {
        super(json);
    }


    @Override
    protected Type getType() {
        return new TypeToken<ChampionImage>() {
        }.getType();
    }
}
