package com.yasinyazici.riot.config.json.impl;

import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.masteries.Masteries;

import java.lang.reflect.Type;

/**
 * Created by Yasin on 14.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class MasteriesParser extends JsonDataParser<Masteries> {

    public MasteriesParser(String json) {
        super(json);
    }

    @Override
    public Masteries get() {
        return null;
    }

    @Override
    protected Type getType() {
        return null;
    }
}
