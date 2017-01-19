package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.masteries.MasteryData;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by Yasin on 19.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class MasteryDataParser extends JsonDataParser<MasteryData> {

    public MasteryDataParser(String json) {
        super(json);
    }

    @Override
    public MasteryData get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<MasteryData>(){}.getType();
    }


}
